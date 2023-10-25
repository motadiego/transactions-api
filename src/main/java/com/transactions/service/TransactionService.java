package com.transactions.service;

import com.transactions.domain.Account;
import com.transactions.domain.Transaction;
import com.transactions.dto.request.TransactionRequestDTO;
import com.transactions.exception.ResourceNotFoundException;
import com.transactions.mapper.TransactionMapper;
import com.transactions.processor.TransactionProcessorFactory;
import com.transactions.repository.AccountRepository;
import com.transactions.repository.TransactionRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

/**
 * @author Diego Mota
 */
@Service
public class TransactionService {

    private final TransactionMapper transactionMapper;

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;


    public TransactionService(TransactionMapper transactionMapper,
        TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionMapper = transactionMapper;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public Integer create(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = transactionMapper.transactionRequestDTOToTransaction(
            transactionRequestDTO);
        transaction.setAccount(findAccount(transaction.getAccount().getId()));
        transaction.setEventDate(LocalDateTime.now());
        TransactionProcessorFactory
            .getProcessor(transaction.getOperationType())
            .process(transaction);

        transaction = transactionRepository.save(transaction);
        return transaction.getId();
    }

    private Account findAccount(Integer accountId) {
        return accountRepository
            .findById(accountId)
            .orElseThrow(
                () -> new ResourceNotFoundException("Account not found for id: " + accountId));
    }
}

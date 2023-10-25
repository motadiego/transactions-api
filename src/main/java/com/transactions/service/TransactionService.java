package com.transactions.service;

import com.transactions.domain.Transaction;
import com.transactions.dto.request.TransactionRequestDTO;
import com.transactions.mapper.TransactionMapper;
import com.transactions.processor.TransactionProcessorFactory;
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

    public TransactionService(TransactionMapper transactionMapper,
        TransactionRepository transactionRepository) {
        this.transactionMapper = transactionMapper;
        this.transactionRepository = transactionRepository;
    }

    public Integer create(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = transactionMapper.transactionRequestDTOToTransaction(transactionRequestDTO);
        transaction.setEventDate(LocalDateTime.now());
        TransactionProcessorFactory
            .getProcessor(transaction.getOperationType())
            .process(transaction);
        transaction = transactionRepository.save(transaction);
        return transaction.getId();
    }


}

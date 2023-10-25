package com.transactions.service;

import com.transactions.domain.Account;
import com.transactions.dto.request.AccountRequestDTO;
import com.transactions.dto.response.AccountResponseDTO;
import com.transactions.exception.ResourceNotFoundException;
import com.transactions.mapper.AccountMapper;
import com.transactions.repository.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author Diego Mota
 */
@Service
public class AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public AccountService(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    public Integer create(AccountRequestDTO accountRequestDTO) {
        Account account = accountMapper.accountRequestDTOToAccount(accountRequestDTO);
        account = accountRepository.save(account);
        return account.getId();
    }

    public AccountResponseDTO findById(Integer id) {
        return accountMapper.accountToAccountResponseDTO(accountRepository
            .findById(id)
            .orElseThrow(ResourceNotFoundException::new));
    }

}
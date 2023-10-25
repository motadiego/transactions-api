package com.transactions.service;

import com.transactions.domain.Account;
import com.transactions.dto.AccountDTO;
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

    public Integer create(AccountDTO accountDTO) {
        Account account = accountMapper.accountDTOToAccount(accountDTO);
        accountRepository.save(account);
        return account.getId();
    }

    public AccountDTO findById(Integer id) {
        return accountMapper.accountToAccountDTO(accountRepository
            .findById(id)
            .orElseThrow(ResourceNotFoundException::new));
    }

}
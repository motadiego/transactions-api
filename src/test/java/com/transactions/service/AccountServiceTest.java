package com.transactions.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.transactions.domain.Account;
import com.transactions.dto.request.AccountRequestDTO;
import com.transactions.dto.response.AccountResponseDTO;
import com.transactions.exception.ResourceNotFoundException;
import com.transactions.mapper.AccountMapper;
import com.transactions.repository.AccountRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Diego Mota
 */
public class AccountServiceTest {

    private AccountMapper accountMapper = AccountMapper.INSTANCE;

    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        accountService = new AccountService(accountMapper, accountRepository);
    }

    @Test
    public void createAccount() throws Exception {
        Account account = Account.builder().id(1).documentNumber("123456").build();
        Integer expectedResult = 1;

        AccountRequestDTO accountRequestDTO = AccountRequestDTO.builder()
            .documentNumber("123456")
            .build();

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Integer result = accountService.create(accountRequestDTO);

        assertEquals(expectedResult, result);
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    public void findAccountById() {
        Account account = Account.builder().id(1).build();

        when(accountRepository.findById(anyInt())).thenReturn(Optional.ofNullable(account));

        AccountResponseDTO accountResponseDTO = accountService.findById(1);

        assertEquals("1", accountResponseDTO.getId());
        verify(accountRepository, times(1)).findById(any());
    }


    @Test(expected = ResourceNotFoundException.class)
    public void findByIdThrowsException()  {
        when(accountRepository.findById(anyInt())).thenThrow(ResourceNotFoundException.class);

        AccountResponseDTO accountResponseDTO = accountService.findById(1);

        verify(accountRepository, times(1)).findById(any());
    }

}
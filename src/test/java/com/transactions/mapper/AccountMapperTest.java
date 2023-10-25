package com.transactions.mapper;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.Account;
import com.transactions.dto.AccountDTO;
import org.junit.Test;

/**
 *
 * @author Diego Mota
 *
 */
public class AccountMapperTest {

    private static final Integer ID = 1;
    private static final String DOCUMENT_NUMBER = "123456";

    private AccountMapper accountMapper = AccountMapper.INSTANCE;

    @Test
    public void accountToAccountDTO() {
        Account account = Account.builder()
            .id(ID)
            .documentNumber(DOCUMENT_NUMBER)
            .build();

        AccountDTO accountDTO = accountMapper.accountToAccountDTO(account);

        assertEquals(String.valueOf(ID), accountDTO.getId());
        assertEquals(DOCUMENT_NUMBER, accountDTO.getDocumentNumber());
    }

    @Test
    public void accountDTOToAccount() {
        AccountDTO accountDTO = AccountDTO.builder()
            .id(String.valueOf(ID))
            .documentNumber(DOCUMENT_NUMBER)
            .build();

        Account account = accountMapper.accountDTOToAccount(accountDTO);

        assertEquals(ID, account.getId());
        assertEquals(DOCUMENT_NUMBER, account.getDocumentNumber());
    }

}
package com.transactions.mapper;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.Account;
import com.transactions.dto.request.AccountRequestDTO;
import com.transactions.dto.response.AccountResponseDTO;
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
    public void accountToAccountResponseDTO() {
        Account account = Account.builder()
            .id(ID)
            .documentNumber(DOCUMENT_NUMBER)
            .build();

        AccountResponseDTO accountResponseDTO = accountMapper.accountToAccountResponseDTO(account);

        assertEquals(String.valueOf(ID), accountResponseDTO.getId());
        assertEquals(DOCUMENT_NUMBER, accountResponseDTO.getDocumentNumber());
    }

    @Test
    public void accountRequestDTOToAccount() {
        AccountRequestDTO accountRequestDTO = AccountRequestDTO.builder()
            .documentNumber(DOCUMENT_NUMBER)
            .build();

        Account account = accountMapper.accountRequestDTOToAccount(accountRequestDTO);

        assertEquals(DOCUMENT_NUMBER, account.getDocumentNumber());
    }

}
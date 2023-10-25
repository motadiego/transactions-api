package com.transactions.mapper;

import com.transactions.domain.Account;
import com.transactions.dto.AccountDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T21:17:06-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO accountToAccountDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        if ( account.getId() != null ) {
            accountDTO.setId( String.valueOf( account.getId() ) );
        }
        accountDTO.setDocumentNumber( account.getDocumentNumber() );

        return accountDTO;
    }

    @Override
    public Account accountDTOToAccount(AccountDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        Account account = new Account();

        if ( accountDTO.getId() != null ) {
            account.setId( Integer.parseInt( accountDTO.getId() ) );
        }
        account.setDocumentNumber( accountDTO.getDocumentNumber() );

        return account;
    }
}

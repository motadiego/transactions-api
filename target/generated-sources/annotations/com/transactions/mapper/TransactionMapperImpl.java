package com.transactions.mapper;

import com.transactions.domain.Transaction;
import com.transactions.dto.TransactionDTO;
import java.math.BigDecimal;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T21:17:06-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        if ( transaction.getId() != null ) {
            transactionDTO.setId( String.valueOf( transaction.getId() ) );
        }
        if ( transaction.getAccountId() != null ) {
            transactionDTO.setAccountId( String.valueOf( transaction.getAccountId() ) );
        }
        if ( transaction.getOperationType() != null ) {
            transactionDTO.setOperationType( transaction.getOperationType().name() );
        }
        if ( transaction.getAmount() != null ) {
            transactionDTO.setAmount( transaction.getAmount().toString() );
        }
        transactionDTO.setEventDate( transaction.getEventDate() );

        return transactionDTO;
    }

    @Override
    public Transaction transactionDTOToTransaction(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        if ( transactionDTO.getId() != null ) {
            transaction.setId( Integer.parseInt( transactionDTO.getId() ) );
        }
        if ( transactionDTO.getAccountId() != null ) {
            transaction.setAccountId( Integer.parseInt( transactionDTO.getAccountId() ) );
        }
        transaction.setOperationType( mapOperationType( transactionDTO.getOperationType() ) );
        if ( transactionDTO.getAmount() != null ) {
            transaction.setAmount( new BigDecimal( transactionDTO.getAmount() ) );
        }
        transaction.setEventDate( transactionDTO.getEventDate() );

        return transaction;
    }
}

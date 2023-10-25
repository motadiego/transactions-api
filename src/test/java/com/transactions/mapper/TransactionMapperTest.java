package com.transactions.mapper;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.Account;
import com.transactions.domain.OperationType;
import com.transactions.domain.Transaction;
import com.transactions.dto.AccountDTO;
import com.transactions.dto.TransactionDTO;
import java.math.BigDecimal;
import org.junit.Test;

/**
 *
 * @author Diego Mota
 *
 */
public class TransactionMapperTest  {

    private static final Integer ID = 1;

    private static final Integer ACCOUNT_ID = 1;

    private static final OperationType OPERATION_TYPE=  OperationType.PAGAMENTO;

    private static final BigDecimal AMOUNT = new BigDecimal( 10.0);

    private TransactionMapper transactionMapper = TransactionMapper.INSTANCE;


    @Test
    public void transacationToTransactionDTO() {
        Transaction transaction = Transaction.builder()
            .id(ID)
            .accountId(ACCOUNT_ID)
            .operationType(OPERATION_TYPE)
            .amount(AMOUNT)
            .build();

        TransactionDTO transactionDTO = transactionMapper.transactionToTransactionDTO(transaction);

        assertEquals(String.valueOf(ID), transactionDTO.getId());
        assertEquals(String.valueOf(ACCOUNT_ID), transactionDTO.getAccountId());
        assertEquals(OPERATION_TYPE.toString(), transactionDTO.getOperationType());
        assertEquals(AMOUNT.toString(), transactionDTO.getAmount());
    }

    @Test
    public void transacationDTOToTransaction() {
        TransactionDTO transactionDTO = TransactionDTO.builder()
            .id(String.valueOf(ID))
            .accountId(String.valueOf(ACCOUNT_ID))
            .operationType(String.valueOf(OPERATION_TYPE.getCode()))
            .amount(AMOUNT.toString())
            .build();

        Transaction transaction = transactionMapper.transactionDTOToTransaction(transactionDTO);

        assertEquals(ID, transaction.getId());
        assertEquals(ACCOUNT_ID, transaction.getAccountId());
        assertEquals(OPERATION_TYPE, transaction.getOperationType());
        assertEquals(AMOUNT, transaction.getAmount());
    }

}
package com.transactions.mapper;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.OperationType;
import com.transactions.domain.Transaction;
import com.transactions.dto.TransactionRequestDTO;
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
    public void transacationToTransactionRequestDTO() {
        Transaction transaction = Transaction.builder()
            .id(ID)
            .accountId(ACCOUNT_ID)
            .operationType(OPERATION_TYPE)
            .amount(AMOUNT)
            .build();

        TransactionRequestDTO transactionRequestDTO = transactionMapper.transactionToTransactionRequestDTO(transaction);

        assertEquals(String.valueOf(ID), transactionRequestDTO.getId());
        assertEquals(String.valueOf(ACCOUNT_ID), transactionRequestDTO.getAccountId());
        assertEquals(OPERATION_TYPE.toString(), transactionRequestDTO.getOperationType());
        assertEquals(AMOUNT.toString(), transactionRequestDTO.getAmount());
    }

    @Test
    public void transacationRequestDTOToTransaction() {
        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
            .id(String.valueOf(ID))
            .accountId(String.valueOf(ACCOUNT_ID))
            .operationType(String.valueOf(OPERATION_TYPE.getCode()))
            .amount(AMOUNT.toString())
            .build();

        Transaction transaction = transactionMapper.transactionRequestDTOToTransaction(
            transactionRequestDTO);

        assertEquals(ID, transaction.getId());
        assertEquals(ACCOUNT_ID, transaction.getAccountId());
        assertEquals(OPERATION_TYPE, transaction.getOperationType());
        assertEquals(AMOUNT, transaction.getAmount());
    }

}
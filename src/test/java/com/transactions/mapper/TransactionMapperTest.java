package com.transactions.mapper;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.OperationType;
import com.transactions.domain.Transaction;
import com.transactions.dto.request.TransactionRequestDTO;
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
    public void transacationRequestDTOToTransaction() {
        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
            .accountId(String.valueOf(ACCOUNT_ID))
            .operationType(String.valueOf(OPERATION_TYPE.getCode()))
            .amount(AMOUNT.toString())
            .build();

        Transaction transaction = transactionMapper.transactionRequestDTOToTransaction(
            transactionRequestDTO);

        assertEquals(ACCOUNT_ID, transaction.getAccount().getId());
        assertEquals(OPERATION_TYPE, transaction.getOperationType());
        assertEquals(AMOUNT, transaction.getAmount());
    }

}
package com.transactions.processor;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.Account;
import com.transactions.domain.Transaction;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * @author Diego Mota
 */
public class PagamentoProcessorTest {

    @Test
    public void process() {
        TransactionProcessor transactionProcessor = PagamentoProcessor.newIntance();

        BigDecimal expectedValue = new BigDecimal(50);

        Transaction transaction = Transaction.builder().amount(new BigDecimal(50)).build();
        transaction.setAccount(Account.builder().documentNumber("123456").availableCreditLimit(new BigDecimal(10)).build());

        Transaction result = transactionProcessor.process(transaction);

        assertEquals(0, result.getAmount().compareTo(expectedValue));
    }

}
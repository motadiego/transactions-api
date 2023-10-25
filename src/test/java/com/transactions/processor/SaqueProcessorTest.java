package com.transactions.processor;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.Transaction;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * @author Diego Mota
 */
public class SaqueProcessorTest {

    @Test
    public void process() {
        TransactionProcessor transactionProcessor = SaqueProcessor.newIntance();

        BigDecimal expectedValue = new BigDecimal(-18.25);

        Transaction transaction = Transaction.builder().amount(new BigDecimal(18.25)).build();

        Transaction result = transactionProcessor.process(transaction);

        assertEquals(0, result.getAmount().compareTo(expectedValue));
    }

}
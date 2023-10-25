package com.transactions.processor;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.Transaction;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * @author Diego Mota
 */
public class CompraParceladaProcessorTest {

    @Test
    public void process() {
        TransactionProcessor transactionProcessor = CompraParceladaProcessor.newIntance();

        BigDecimal expectedValue = new BigDecimal(-100);

        Transaction transaction = Transaction.builder().amount(new BigDecimal(100)).build();

        Transaction result = transactionProcessor.process(transaction);

        assertEquals(0, result.getAmount().compareTo(expectedValue));
    }

}
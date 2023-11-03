package com.transactions.processor;

import static org.junit.Assert.assertEquals;

import com.transactions.domain.Account;
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
        transaction.setAccount(
            Account.builder().documentNumber("123456").availableCreditLimit(new BigDecimal(50)).build());

        Transaction result = transactionProcessor.process(transaction);

        assertEquals(0, result.getAmount().compareTo(expectedValue));
    }

}
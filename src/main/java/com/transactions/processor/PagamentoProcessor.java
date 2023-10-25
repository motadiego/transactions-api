package com.transactions.processor;

import com.transactions.domain.Transaction;
import java.math.BigDecimal;

/**
 * @author Diego Mota
 */
public class PagamentoProcessor implements TransactionProcessor {

    private PagamentoProcessor() {
    }

    public static PagamentoProcessor newIntance() {
        return new PagamentoProcessor();
    }

    @Override
    public Transaction process(Transaction transaction) {
        BigDecimal positiveAmount = transaction.getAmount();
        transaction.setAmount(positiveAmount);
        return transaction;
    }

}
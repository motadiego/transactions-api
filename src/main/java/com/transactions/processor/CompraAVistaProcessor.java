package com.transactions.processor;

import com.transactions.domain.Transaction;
import com.transactions.repository.AccountRepository;
import java.math.BigDecimal;

/**
 * @author Diego Mota
 */
public class CompraAVistaProcessor implements TransactionProcessor {

    private CompraAVistaProcessor() {
    }

    public static CompraAVistaProcessor newIntance() {
        return new CompraAVistaProcessor();
    }

    @Override
    public Transaction process(Transaction transaction) {
        BigDecimal negativeAmount = transaction.getAmount().negate();
        transaction.setAmount(negativeAmount);
        return transaction;
    }

}
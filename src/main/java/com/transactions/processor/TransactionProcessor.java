package com.transactions.processor;

import com.transactions.domain.Transaction;

/**
 * @author Diego Mota
 */
public interface TransactionProcessor {

    Transaction process(Transaction transaction);

}
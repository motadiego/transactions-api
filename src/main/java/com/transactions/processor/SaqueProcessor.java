package com.transactions.processor;

import com.transactions.domain.Transaction;
import java.math.BigDecimal;

/**
 * 
 * @author Diego Mota
 *
 */
public class SaqueProcessor implements TransactionProcessor {

	private SaqueProcessor() { }
	
	public static SaqueProcessor newIntance() {
		return new SaqueProcessor();
	}
	
	@Override
	public Transaction process(Transaction transaction) {
		BigDecimal negativeAmount = transaction.getAmount().negate();
		transaction.setAmount(negativeAmount);
		return transaction;
	}
	
}
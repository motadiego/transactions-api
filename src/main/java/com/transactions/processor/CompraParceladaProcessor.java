package com.transactions.processor;

import com.transactions.domain.Transaction;
import java.math.BigDecimal;

/**
 * 
 * @author Diego Mota
 *
 */
public class CompraParceladaProcessor implements TransactionProcessor {

	private CompraParceladaProcessor() { }
	
	public static CompraParceladaProcessor newIntance() {
		return new CompraParceladaProcessor();
	}
	
	@Override
	public Transaction process(Transaction transaction) {
		BigDecimal negativeAmount = transaction.getAmount().negate();
		transaction.setAmount(negativeAmount);
		return transaction;
	}
	
}
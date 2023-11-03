package com.transactions.processor;

import com.transactions.domain.Transaction;
import com.transactions.exception.ValidationException;
import java.math.BigDecimal;

/**
 * 
 * @author Diego Mota
 *
 */
public class SaqueProcessor implements TransactionProcessor {


	private SaqueProcessor() {
	}
	
	public static SaqueProcessor newIntance() {
		return new SaqueProcessor();
	}
	
	@Override
	public Transaction process(Transaction transaction) {
		if(transaction.getAmount().doubleValue()  > transaction.getAccount().getAvailableCreditLimit().doubleValue()){
			throw new ValidationException("Value exceeds limit");
		}

		transaction.getAccount().setAvailableCreditLimit(transaction.getAccount().getAvailableCreditLimit().subtract(transaction.getAmount()));

		BigDecimal negativeAmount = transaction.getAmount().negate();
		transaction.setAmount(negativeAmount);
		return transaction;
	}

}
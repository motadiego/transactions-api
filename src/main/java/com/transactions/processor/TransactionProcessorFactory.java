package com.transactions.processor;

import com.transactions.domain.OperationType;

/**
 * @author Diego Mota
 */
public class TransactionProcessorFactory {

    private TransactionProcessorFactory() {
    }

    public static TransactionProcessor getProcessor(OperationType operationType) {
        TransactionProcessor transactionProcessor = null;
        switch (operationType) {
            case COMPRA_A_VISTA:
                transactionProcessor = CompraAVistaProcessor.newIntance();
                break;
            case COMPRA_PARCELADA:
                transactionProcessor = CompraParceladaProcessor.newIntance();
                break;
            case SAQUE:
                transactionProcessor = SaqueProcessor.newIntance();
                break;
            case PAGAMENTO:
                transactionProcessor = PagamentoProcessor.newIntance();
                break;
            default:
                throw new IllegalArgumentException();
        }
        return transactionProcessor;
    }

}

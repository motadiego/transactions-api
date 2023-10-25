package com.transactions.processor;

import static org.assertj.core.api.Assertions.assertThat;

import com.transactions.domain.OperationType;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Diego Mota
 */
public class TransactionProcessorFactoryTest {

    @Test
    public void getCompraAVistaProcessor() {
        TransactionProcessor transactionProcessor = TransactionProcessorFactory.getProcessor(OperationType.COMPRA_A_VISTA);

        assertThat(transactionProcessor).isInstanceOf(CompraAVistaProcessor.class);
    }

    @Test
    public void getCompraParceladaProcessor() {
        TransactionProcessor transactionProcessor = TransactionProcessorFactory.getProcessor(OperationType.COMPRA_PARCELADA);

        assertThat(transactionProcessor).isInstanceOf(CompraParceladaProcessor.class);
    }

    @Test
    public void getSaqueProcessor() {
        TransactionProcessor transactionProcessor = TransactionProcessorFactory.getProcessor(OperationType.SAQUE);

        assertThat(transactionProcessor).isInstanceOf(SaqueProcessor.class);
    }

    @Test
    public void getPagamentoProcessor() {
        TransactionProcessor transactionProcessor = TransactionProcessorFactory.getProcessor(OperationType.PAGAMENTO);

        assertThat(transactionProcessor).isInstanceOf(PagamentoProcessor.class);
    }
}
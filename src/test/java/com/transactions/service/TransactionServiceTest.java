package com.transactions.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.transactions.domain.OperationType;
import com.transactions.domain.Transaction;
import com.transactions.dto.TransactionRequestDTO;
import com.transactions.mapper.TransactionMapper;
import com.transactions.repository.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Diego Mota
 */
public class TransactionServiceTest  {

    private TransactionMapper transactionMapper = TransactionMapper.INSTANCE;

    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        transactionService = new TransactionService(transactionMapper, transactionRepository);
    }


    @Test
    public void createTransaction() throws Exception {
        Integer expectedResult = 1;
        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
            .id("1")
            .accountId("1")
            .amount("10.0")
            .operationType(String.valueOf(OperationType.PAGAMENTO.getCode()))
            .build();

        Integer result = transactionService.create(transactionRequestDTO);

        assertEquals(expectedResult, result);
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    
}
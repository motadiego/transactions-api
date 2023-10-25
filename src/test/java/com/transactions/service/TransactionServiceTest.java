package com.transactions.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.transactions.domain.Account;
import com.transactions.domain.OperationType;
import com.transactions.domain.Transaction;
import com.transactions.dto.request.TransactionRequestDTO;
import com.transactions.mapper.TransactionMapper;
import com.transactions.repository.AccountRepository;
import com.transactions.repository.TransactionRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Diego Mota
 */
public class TransactionServiceTest {

    private TransactionMapper transactionMapper = TransactionMapper.INSTANCE;

    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        transactionService = new TransactionService(transactionMapper, transactionRepository, accountRepository);
    }


    @Test
    public void createTransaction() throws Exception {
        Account account = Account.builder().id(1).build();
        Transaction transaction = Transaction.builder().id(1).account(account)
            .operationType(OperationType.PAGAMENTO).amount(new BigDecimal(10.0)).build();
        Integer expectedResult = 1;

        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
            .accountId("1")
            .amount("10.0")
            .operationType(String.valueOf(OperationType.PAGAMENTO.getCode()))
            .build();

        when(accountRepository.findById(anyInt())).thenReturn(Optional.ofNullable(account));

        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        Integer result = transactionService.create(transactionRequestDTO);

        assertEquals(expectedResult, result);
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }


}
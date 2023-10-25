package com.transactions.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.transactions.domain.OperationType;
import com.transactions.dto.request.TransactionRequestDTO;
import com.transactions.service.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Diego Mota
 */
public class TransactionControllerTest extends AbstractRestControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
            .standaloneSetup(transactionController)
            .setControllerAdvice(new RestResponseEntityExceptionHandler())
            .build();
    }


    @Test
    public void createTransaction() throws Exception {
        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
            .accountId("1")
            .amount("10.0")
            .operationType(String.valueOf(OperationType.PAGAMENTO.getCode()))
            .build();

        when(transactionService.create(transactionRequestDTO)).thenReturn(1);

        mockMvc.perform(post(TransactionController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(transactionRequestDTO)))
            .andExpect(status().isCreated())
            .andExpect(header().string("location", containsString("/transactions/1")));
    }

}
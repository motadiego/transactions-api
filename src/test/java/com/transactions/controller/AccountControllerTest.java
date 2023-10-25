package com.transactions.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.transactions.dto.request.AccountRequestDTO;
import com.transactions.dto.response.AccountResponseDTO;
import com.transactions.exception.ResourceNotFoundException;
import com.transactions.service.AccountService;
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
public class AccountControllerTest extends AbstractRestControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
            .standaloneSetup(accountController)
            .setControllerAdvice(new RestResponseEntityExceptionHandler())
            .build();
    }


    @Test
    public void createAccount() throws Exception {
        AccountRequestDTO account = AccountRequestDTO.builder()
            .documentNumber("123456")
            .build();

        when(accountService.create(account)).thenReturn(1);

        mockMvc.perform(post(AccountController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(account)))
            .andExpect(status().isCreated())
            .andExpect(header().string("location", containsString("/accounts/1")));
    }

    @Test
    public void checkAccountNotFound() throws Exception {
        when(accountService.findById(anyInt())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(AccountController.BASE_URL.concat("/1"))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }


    @Test
    public void findAccountById() throws Exception {
        AccountResponseDTO account = AccountResponseDTO.builder()
            .id("1")
            .documentNumber("123456")
            .build();

        when(accountService.findById(anyInt())).thenReturn(account);

        mockMvc.perform(get(AccountController.BASE_URL.concat("/1"))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.account_id", equalTo("1")))
            .andExpect(jsonPath("$.document_number", equalTo("123456")));
    }

}

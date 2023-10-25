package com.transactions.controller;

import com.transactions.dto.request.AccountRequestDTO;
import com.transactions.dto.response.AccountResponseDTO;
import com.transactions.service.AccountService;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Diego Mota
 */
@RestController
@RequestMapping(AccountController.BASE_URL)
public class AccountController {

    public static final String BASE_URL = "/accounts";

    private final AccountService accountService;

    public AccountController(AccountService paymentService) {
        this.accountService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        Integer id = accountService.create(accountRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(id).toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("location", location.toString());
        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeaders).build();
    }

    @GetMapping(path = "/{id}")
    public AccountResponseDTO findAccountById(@PathVariable("id") Integer id) {
        return accountService.findById(id);
    }

}

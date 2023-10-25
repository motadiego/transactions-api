package com.transactions.controller;

import com.transactions.dto.TransactionDTO;
import com.transactions.service.TransactionService;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Diego Mota
 */
@RestController
@RequestMapping(TransactionController.BASE_URL)
public class TransactionController {

    public static final String BASE_URL = "/transactions";

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody TransactionDTO transactionDTO) {
        Integer id = transactionService.create(transactionDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(id).toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("location", location.toString());
        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeaders).build();
    }

}

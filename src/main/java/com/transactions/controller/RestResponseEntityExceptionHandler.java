package com.transactions.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.transactions.exception.ResourceNotFoundException;

/**
 * @author Diego Mota
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(),
            HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> IllegalArgumentException(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(),
            HttpStatus.BAD_REQUEST);
    }
}
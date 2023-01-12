package com.example.gerenciadorDePessoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ValidationController {

    MessageExceptionHandler messageExceptionHandler = new MessageExceptionHandler();

    @ExceptionHandler(LoginNotExistsException.class)
    public ResponseEntity<MessageExceptionHandler> exceptionLoginExists() {
        messageExceptionHandler.setMessage("Login não encontrado!");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.NOT_FOUND);

    }
}
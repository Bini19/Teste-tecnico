package com.example.gerenciadorDePessoas.exception;

public class LoginNotExistsException extends RuntimeException {
    public LoginNotExistsException() {
        super("Login não encontrado!");
    }
}
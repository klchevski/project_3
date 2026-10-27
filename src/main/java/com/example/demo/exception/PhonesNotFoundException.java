package com.example.demo.exception;

public class PhonesNotFoundException extends RuntimeException {
    public PhonesNotFoundException(String message) {
        super(message);
    }
}

package com.example.school.exceptions;

public class RegisteredSubjectsAlreadyException extends RuntimeException {
    public RegisteredSubjectsAlreadyException(String message) {
        super(message);
    }
}

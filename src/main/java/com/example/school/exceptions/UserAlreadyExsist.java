package com.example.school.exceptions;

public class UserAlreadyExsist extends Throwable {
    public UserAlreadyExsist(String message) {
        super(message);
    }
}

package com.example.school.exceptions;

public class UserAlreadyExist extends Throwable {
    public UserAlreadyExist(String message) {
        super(message);
    }
}

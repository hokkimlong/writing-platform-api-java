package com.example.writingplatformapi.exception;

public class UserexistedException extends Exception {
    public UserexistedException(String email) {
        super(String.format("User with email %s already exists", email));
    }
}

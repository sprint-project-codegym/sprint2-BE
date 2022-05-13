package com.codegym.cinema.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (String message){
        super (message);
    }
}

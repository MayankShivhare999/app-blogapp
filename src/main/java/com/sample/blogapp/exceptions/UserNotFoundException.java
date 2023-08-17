package com.sample.blogapp.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}

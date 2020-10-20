package com.thoughtworks.capacity.gtb.mvc.exception;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException() {
    }

    public InvalidUserException(String message) {
        super(message);
    }
}

package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNameExistsException extends RuntimeException {
    public UserNameExistsException() {
        super();
    }

    public UserNameExistsException(String message) {
        super(message);
    }
}

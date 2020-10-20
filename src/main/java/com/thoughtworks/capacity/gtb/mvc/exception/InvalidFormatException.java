package com.thoughtworks.capacity.gtb.mvc.exception;

public class InvalidFormatException extends RuntimeException {
    public InvalidFormatException() {
    }

    public InvalidFormatException(String message) {
        super(message);
    }
}

package org.kuznetsov.sd7.supermarket.model.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}

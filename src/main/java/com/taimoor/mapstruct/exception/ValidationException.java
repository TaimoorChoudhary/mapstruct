package com.taimoor.mapstruct.exception;

/**
 * @author Taimoor Choudhary
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message) {
        super(message);
    }
}

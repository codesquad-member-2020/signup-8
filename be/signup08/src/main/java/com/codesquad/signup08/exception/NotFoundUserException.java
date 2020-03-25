package com.codesquad.signup08.exception;

public class NotFoundUserException extends RuntimeException {
    private final int ERROR_CODE;

    public NotFoundUserException(String message, int errorCode) {
        super(message);
        this.ERROR_CODE = errorCode;
    }

    public NotFoundUserException(String message) {
        this(message, 404);
    }

    public int getErrorCode() {
        return ERROR_CODE;
    }
}

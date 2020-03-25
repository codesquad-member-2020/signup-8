package com.codesquad.signup08.domain;

public class ResponseResult {
    private boolean valid;
    private String errorMessage;

    public ResponseResult(boolean valid, String errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static ResponseResult ok() {
        return new ResponseResult(true, null);
    }

    public static ResponseResult fail(String errorMessage) {
        return new ResponseResult(false, errorMessage);
    }
}

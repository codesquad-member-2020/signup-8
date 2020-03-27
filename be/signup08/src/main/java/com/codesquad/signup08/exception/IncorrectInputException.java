package com.codesquad.signup08.exception;

public class IncorrectInputException extends RuntimeException {

    public IncorrectInputException() {
        super("잘못된 정보를 입력 하였습니다. 다시 입력 해주세요.");
    }
    public IncorrectInputException(String errorMessage, Throwable t) {
        super(errorMessage);
        t.printStackTrace();
    }
}

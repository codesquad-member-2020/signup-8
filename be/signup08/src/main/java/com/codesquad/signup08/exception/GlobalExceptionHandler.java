package com.codesquad.signup08.exception;

import com.codesquad.signup08.domain.ResponseResult;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundUserException.class)
    public @ResponseBody ResponseResult handleUserNotFoundException(NotFoundUserException e) {
        return new ResponseResult(false, e.getMessage());
    }

    @ExceptionHandler(IncorrectInputException.class)
    public @ResponseBody ResponseResult handleIncorrectInputException(IncorrectInputException e) {
        return new ResponseResult(false, e.getMessage());
    }

    @ExceptionHandler(DbActionExecutionException.class)
    public @ResponseBody ResponseResult catchBadRequestException(DbActionExecutionException e) {
        final String BAD_REQUEST_MESSAGE = "잘못된 요청입니다.";
        return new ResponseResult(false, BAD_REQUEST_MESSAGE);
    }
}

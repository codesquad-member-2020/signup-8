package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.ResponseResult;
import com.codesquad.signup08.domain.User;
import com.codesquad.signup08.domain.UserRepository;
import com.codesquad.signup08.exception.NotFoundUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class ApiUserController {
    private static final Logger log = LoggerFactory.getLogger(ApiUserController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public ResponseResult join(User user) {
        log.debug("UserId : {}", user);
        userRepository.save(user);
        return new ResponseResult(true, null);
    }

    @PostMapping("/login")
    public ResponseResult login(String userId, String password, HttpSession session) {
        log.debug("userId : {}, password : {}", userId, password);
        final String NOT_FOUND_USER = "회원 정보가 존재하지 않습니다.";
        User sessionUser = userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundUserException(NOT_FOUND_USER));
        log.debug("sessionser : {}", sessionUser);

        if(!sessionUser.matchPassword(password)) {
            final String NOT_MATCH_PASSWORD_MESSAGE = "비밀번호가 일치하지 않습니다.";
            log.debug("[*] error message : {}", NOT_MATCH_PASSWORD_MESSAGE);
            return new ResponseResult(false, NOT_MATCH_PASSWORD_MESSAGE);
        }

        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, sessionUser);
        log.debug("Login Success!");
        return new ResponseResult(true, null);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseResult catchBadRequestException(DbActionExecutionException e) {
        log.debug("[*] {}", e.getMessage());
        final String BAD_REQUEST_MESSAGE = "잘못된 요청입니다.";
        return new ResponseResult(false, BAD_REQUEST_MESSAGE);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseResult catchNotFoundUserException(NotFoundUserException e) {
        log.debug("[*] {}", e.getMessage());
        return new ResponseResult(false, e.getMessage());
    }
}

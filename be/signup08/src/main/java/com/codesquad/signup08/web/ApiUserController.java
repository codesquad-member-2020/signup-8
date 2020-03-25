package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.ResponseResult;
import com.codesquad.signup08.domain.User;
import com.codesquad.signup08.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseResult catchBadRequestException(Model model, DbActionExecutionException e) {
        log.debug("[*] {}", e.getMessage());
        final String ERROR_MESSAGE = "잘못된 요청입니다.";
        return new ResponseResult(false, ERROR_MESSAGE);
    }
}

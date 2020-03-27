package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.ResponseResult;
import com.codesquad.signup08.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/duplicate")
public class ApiDuplicateController {
    private static final Logger log = LoggerFactory.getLogger(ApiDuplicateController.class);
    static final String DUPLICATED_MESSAGE = "중복입니다.";
    static final String NOT_DUPLICATED_MESSAGE = "중복이 아닙니다.";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public ResponseResult isDuplicatedUser(@RequestParam(required = false) String userId, @RequestParam(required = false) String email, @RequestParam(required = false) String phoneNumber) {
        boolean isDuplicated = false;

        if (userId != null) {
            isDuplicated = isDuplicatedUserId(userId);
        }

        if (email != null) {
            isDuplicated = isDuplicatedEmail(email);
        }

        if (phoneNumber != null) {
            isDuplicated = isDuplicatedPhoneNumber(phoneNumber);
        }

        return isDuplicated ? new ResponseResult(true, DUPLICATED_MESSAGE) : new ResponseResult(false, NOT_DUPLICATED_MESSAGE);
    }

    private boolean isDuplicatedUserId(String userId) {
        return userRepository.countUserByUserId(userId) != 0;
    }

    private boolean isDuplicatedEmail(String email) {
        return userRepository.countUserByEmail(email) != 0;
    }

    private boolean isDuplicatedPhoneNumber(String phoneNumber) {
        return userRepository.countUserByPhoneNumber(phoneNumber) != 0;
    }

}

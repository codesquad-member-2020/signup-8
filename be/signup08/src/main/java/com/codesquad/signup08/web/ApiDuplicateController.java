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

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public boolean isDuplicatedUser(@RequestParam(required = false) String userId, @RequestParam(required = false) String email, @RequestParam(required = false) String phoneNumber) {
        if (userId != null) {
            return isDuplicatedUserId(userId);
        }

        if (email != null) {
            return isDuplicatedEmail(email);
        }

        if (phoneNumber != null) {
            return isDuplicatedPhoneNumber(phoneNumber);
        }

        return false;
    }

    private boolean isDuplicatedUserId(String userId) {
        int existedUser = userRepository.countUserByUserId(userId);
        return existedUser == 0 ? false : true;
    }

    private boolean isDuplicatedEmail(String email) {
        int existedUser = userRepository.countUserByEmail(email);
        return existedUser == 0 ? false : true;
    }

    private boolean isDuplicatedPhoneNumber(String phoneNumber) {
        int existedUser = userRepository.countUserByPhoneNumber(phoneNumber);
        return existedUser == 0 ? false : true;
    }

}

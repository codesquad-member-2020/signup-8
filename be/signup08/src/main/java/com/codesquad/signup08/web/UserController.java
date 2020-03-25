package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.User;
import com.codesquad.signup08.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String moveToHome() {
        return "/home";
    }

    @GetMapping("/users/join/form")
    public String moveJoinForm() {
        return "/join";
    }

    @PostMapping("/users")
    public String join(User user) {
        log.debug("UserId : {}", user);
        userRepository.save(user);
        return "redirect:/";
    }

}

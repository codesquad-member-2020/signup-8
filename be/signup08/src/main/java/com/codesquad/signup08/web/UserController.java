package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.User;
import com.codesquad.signup08.domain.UserRepository;
import com.codesquad.signup08.exception.NotFoundUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private String catchBadRequestException(Model model, DbActionExecutionException e) {
        log.debug("[*] {}", e.getMessage());
        final String ERROR_MESSAGE = "잘못된 요청입니다.";
        model.addAttribute("errorMessage", ERROR_MESSAGE);
        return "/error";
    }

}

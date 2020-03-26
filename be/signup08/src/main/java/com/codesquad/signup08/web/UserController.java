package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.User;
import com.codesquad.signup08.domain.UserRepository;
import com.codesquad.signup08.exception.NotFoundUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/join/form")
    public String moveJoinForm() {
        return "/join";
    }

    @GetMapping("/login/form")
    public String moveLoginForm() { return "/login"; }

        }

        return "redirect:/";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String catchNotFoundUserException(Model model, NotFoundUserException e) {
        log.debug("[*] {}", e.getMessage());
        model.addAttribute("errorMessage", e.getMessage());
        return "/error";
    }

}

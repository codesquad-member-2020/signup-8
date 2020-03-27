package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.ResponseResult;
import com.codesquad.signup08.domain.User;
import com.codesquad.signup08.domain.UserRepository;
import com.codesquad.signup08.exception.IncorrectInputException;
import com.codesquad.signup08.exception.NotFoundUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return "/signup";
    }

    @PostMapping("")
    public ResponseEntity<String> join(User user) {
        log.debug("UserId : {}", user);
        userRepository.save(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", "/");
        return ResponseEntity.status(HttpStatus.FOUND)
                .headers(responseHeaders)
                .body("success");
    }

    @GetMapping("/login/form")
    public String moveLoginForm() { return "/login"; }

    @PostMapping("/login")
    public ResponseEntity<String> login(String userId, String password, HttpSession session) {
        log.debug("userId : {}, password : {}", userId, password);
        final String NOT_FOUND_USER = "회원 정보가 존재하지 않습니다.";
        User sessionUser = userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundUserException(NOT_FOUND_USER));
        log.debug("sessionser : {}", sessionUser);

        if(sessionUser.isDifferentPassword(password)) {
            throw new IncorrectInputException();
        }

        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, sessionUser);
        log.debug("Login Success!");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", "/");
        return ResponseEntity.status(HttpStatus.FOUND)
                .headers(responseHeaders)
                .body("success");
    }

    @GetMapping("")
    public String viewProfile(Model model, HttpSession session) {
        log.debug("[*] session getId : {}", session.getId());
        if (HttpSessionUtils.isNotLoginUser(session)) {
            final String NOT_LOGINED_MESSAGE = "로그인이 필요합니다.";
            model.addAttribute("errorMessage", NOT_LOGINED_MESSAGE);
            return "/error";
        }

        User sessionUser = HttpSessionUtils.getUserFromSession(session);
        final String NOT_FOUND_USER = "회원 정보가 존재하지 않습니다.";
        model.addAttribute("currentUser", userRepository.findByUserId(sessionUser.getUserId()).orElseThrow(() -> new NotFoundUserException(NOT_FOUND_USER)));
        return "/profile";
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.removeAttribute("sessionUser");
        session.invalidate();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", "/");
        return ResponseEntity.status(HttpStatus.FOUND)
                .headers(responseHeaders)
                .body("<html><body>You are being redirected</body></html>");
    }

}

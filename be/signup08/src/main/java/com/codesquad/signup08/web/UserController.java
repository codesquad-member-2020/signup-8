package com.codesquad.signup08.web;

import com.codesquad.signup08.domain.User;
import com.codesquad.signup08.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String main() {
        User user = new User("pengsoo", "1234", "팽수", LocalDate.now(), "male", "pangsoo@test.com", "010-1111-2222", new String[]{"보드", "영화"}, "true");
        userRepository.save(user);
        try {

            User newUser = userRepository.findById((long) 1).orElseThrow(() -> new Exception());
            log.debug("user : {}", user);
            log.debug("newUser : {}", newUser);
        } catch (Exception e) {
            log.debug("error!!");
        }
        return "/home";
    }
}

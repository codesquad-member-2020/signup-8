package com.codesquad.signup08.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Arrays;

public class User {
    @Id
    private Long id;
    private String userId;
    private String password;
    private String name;
    private LocalDateTime birthday;
    private String gender;
    private String email;
    private String phoneNumber;
    private String[] interest;
    private boolean agreement;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", interest=" + Arrays.toString(interest) +
                ", agreement=" + agreement +
                '}';
    }
}

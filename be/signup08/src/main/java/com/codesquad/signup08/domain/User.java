package com.codesquad.signup08.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Arrays;

public class User {
    @Id
    private Long id;
    private String userId;
    private String password;
    private String name;
    private LocalDate birthday;
    private String gender;
    private String email;
    private String phoneNumber;
    private String[] interest;
    private String agreement;

    public User(String userId, String password, String name, LocalDate birthday, String gender, String email, String phoneNumber, String[] interest, String agreement) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.interest = interest;
        this.agreement = agreement;
    }

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

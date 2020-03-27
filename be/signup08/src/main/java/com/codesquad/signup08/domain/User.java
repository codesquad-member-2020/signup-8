package com.codesquad.signup08.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    @Id
    @JsonIgnore
    private Long id;

    private String userId;

    @JsonIgnore
    private String password;

    private String name;

    private LocalDate birthday;

    private String gender;

    private String email;

    private String phoneNumber;

    private String interest;

    @JsonIgnore
    private String agreement;

    private LocalDateTime createdDateTime;

    public User() {
        createdDateTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDate getBirthday() {
//        return birthday;
//    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ISO_DATE);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public boolean matchUserId(String inputUserId) {
        return this.userId.equals(inputUserId);
    }

    public boolean matchPassword(String inputPassword) {
        return this.password.equals(inputPassword);
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
                ", interest=" + interest +
                ", agreement=" + agreement +
                '}';
    }
}

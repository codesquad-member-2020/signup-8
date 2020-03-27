package com.codesquad.signup08.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM user WHERE USER_ID = :userId")
    Optional<User> findByUserId(@Param("userId") String userId);

    @Query("SELECT COUNT(*) FROM user WHERE USER_ID = :userId")
    int countUserByUserId(@Param("userId") String userId);

    @Query("SELECT COUNT(*) FROM user WHERE EMAIL = :email")
    int countUserByEmail(@Param("email") String email);

    @Query("SELECT COUNT(*) FROM user WHERE PHONE_NUMBER = :phoneNumber")
    int countUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}

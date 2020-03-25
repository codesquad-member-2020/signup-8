package com.codesquad.signup08.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM user WHERE USER_ID = :userId")
    Optional<User> findByUserId(@Param("userId") String userId);
}

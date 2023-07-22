package com.accode.restjava.repository;


import com.accode.restjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE email =?1",nativeQuery = true)
    User getUserByEmail(String email);
}

package com.ramjo.spring_security_demo.Spring_Security_Demo.repository;

import com.ramjo.spring_security_demo.Spring_Security_Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

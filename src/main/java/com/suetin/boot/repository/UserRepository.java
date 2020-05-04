package com.suetin.boot.repository;

import com.suetin.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByUsername(String username);
}

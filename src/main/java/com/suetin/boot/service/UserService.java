package com.suetin.boot.service;

import com.suetin.boot.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User saveUser(User user);

    void delete(User user);
}

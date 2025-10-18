package com.language_practice_server.server_demo.service;

import com.language_practice_server.server_demo.domain.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findUserById(Long id);
    void deleteUserById(Long id);
}

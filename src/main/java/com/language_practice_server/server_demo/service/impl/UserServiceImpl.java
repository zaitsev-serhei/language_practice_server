package com.language_practice_server.server_demo.service.impl;

import com.language_practice_server.server_demo.domain.model.User;
import com.language_practice_server.server_demo.domain.repository.UserRepository;
import com.language_practice_server.server_demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        userRepository.findUserByUserName(user.getUserName())
                .ifPresent(u -> {throw new IllegalArgumentException("User already exists");});

        return userRepository.saveUser(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}

package com.language_practice_server.server_demo.domain.repository.impl;

import com.language_practice_server.server_demo.db.entity.UserEntity;
import com.language_practice_server.server_demo.db.repository.UserRepositoryJpa;
import com.language_practice_server.server_demo.domain.model.User;
import com.language_practice_server.server_demo.domain.repository.UserRepository;
import com.language_practice_server.server_demo.mapper.UserMapper;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private UserRepositoryJpa userRepositoryJpa;
    private UserMapper userMapper;

    @Override
    public Optional<User> findUserById(Long id) {
//        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
//        if (id != null) {
//            return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
//        }
        if (id == null) {
            return Optional.empty();
        }

        return userRepositoryJpa.findById(id).map(userMapper::toModel);
    }

    @Override
    public Optional<User> findUserByUserName(String userName) {
        if (userName == null) {
            return Optional.empty();
        }
        return userRepositoryJpa.findByUserName(userName).map(userMapper::toModel);
    }

    @Override
    public User saveUser(User user) {
        UserEntity savedUserEntity = userRepositoryJpa.save(userMapper.toEntity(user));

        return userMapper.toModel(savedUserEntity);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepositoryJpa.deleteById(id);
    }
}

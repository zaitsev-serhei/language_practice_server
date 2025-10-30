package com.language_practice_server.server_demo.web.security.service;

import com.language_practice_server.server_demo.db.entity.UserEntity;
import com.language_practice_server.server_demo.db.repository.UserRepositoryJpa;
import com.language_practice_server.server_demo.web.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Handles user authentication and registration logic.
 * Uses AuthenticationManager, PasswordEncoder, and JwtService to verify credentials and create tokens.
 */

@Service
public class AuthenticationService {
    private final UserRepositoryJpa userRepository; //use UserRepository domain level instead
    private final PasswordEncoder  passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UserRepositoryJpa userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UserEntity signup(UserDto userDto) {
        UserEntity userEntity = new UserEntity(); //use User() instead to work with UserRepository interface
        userEntity.setUserName(userDto.getUserName());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(userEntity);
    }

    // Authenticate user with provided credentials
    // If success, generate JWT and return it
    public UserEntity authenticate(UserDto userDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUserName(),
                        userDto.getPassword()
                ));
        return userRepository.findByUserName(userDto.getUserName()).orElseThrow();
    }
}

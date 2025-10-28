package com.language_practice_server.server_demo.web.controller;

import com.language_practice_server.server_demo.db.entity.UserEntity;
import com.language_practice_server.server_demo.web.dto.UserDto;
import com.language_practice_server.server_demo.web.security.CustomUserDetails;
import com.language_practice_server.server_demo.web.security.service.AuthenticationService;
import com.language_practice_server.server_demo.web.security.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Handles authentication-related HTTP requests (login, register).
 * Communicates with AuthenticationService to validate user and generate JWT.
 */

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        UserEntity userEntity = authenticationService.signup(userDto);
        String token = jwtService.generateToken(new CustomUserDetails(userEntity));

        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody UserDto userDto) {
        UserEntity userEntity = authenticationService.authenticate(userDto);
        String token = jwtService.generateToken(new CustomUserDetails(userEntity));

        return ResponseEntity.ok(Map.of("token", token));
    }
}

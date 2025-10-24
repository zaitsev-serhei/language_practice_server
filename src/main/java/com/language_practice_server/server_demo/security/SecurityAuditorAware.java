package com.language_practice_server.server_demo.security;

import com.language_practice_server.server_demo.domain.model.User;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityAuditorAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        Object user = authentication.getPrincipal();
        if (user instanceof User) {
            return Optional.of(((User) user).getId());
        }
        return Optional.empty();
    }
}

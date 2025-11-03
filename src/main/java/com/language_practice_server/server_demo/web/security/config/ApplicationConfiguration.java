package com.language_practice_server.server_demo.web.security.config;

import com.language_practice_server.server_demo.domain.repository.UserRepository;
import com.language_practice_server.server_demo.mapper.UserMapper;
import com.language_practice_server.server_demo.web.security.CustomUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Application-level configuration class.
 * Defines beans like UserDetailsService, PasswordEncoder, and AuthenticationManager used in Security setup.
 */

@Configuration
public class ApplicationConfiguration {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ApplicationConfiguration(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    /**
     * Creates UserDetailsService bean required by Spring Security for user authentication.
     * 1. Method returns an implementation of UserDetailsService to the Spring container.
     * 2. When a user attempts to log in, Spring Security invokes the loadUserByUsername(username)
     * method implemented by the lambda expression.
     * 3. The chain (repository -> mapper -> adapter) fetches the User (Domain Model),
     * transforms it into UserEntity, and finally converts it into a CustomUserDetails object. (Optional<CustomUserDetails>)
     * 4. This CustomUserDetails (which implements UserDetails) is returned to Spring Security.
     * 5. Spring Security then uses the UserDetails object to compare credentials and manage access.
     */
    @Bean
    UserDetailsService userDetailsService() {
        return username -> userRepository.findUserByUserName(username)
                //Map Domain Model (User) to DB Entity (UserEntity)
                .map(userMapper::toEntity)
                //Map DB Entity (UserEntity) to Spring Security Adapter (CustomUserDetails)
                .map(CustomUserDetails::new) //Constructor Reference. (CustomUserDetails::new) - same as lamba-expression userEntity -> new CustomUserDetails(userEntity)
                // 3. Return the adapter if present, otherwise throw the required Spring exception
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}

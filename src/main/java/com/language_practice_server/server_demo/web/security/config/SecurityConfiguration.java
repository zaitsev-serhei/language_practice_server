package com.language_practice_server.server_demo.web.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Main security configuration class.
 * Defines security rules for HTTP requests, permitted endpoints, and filter chain.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity  http) throws Exception {
        //1.1. all requests on the UI side would be authenticated
//        http.authorizeHttpRequests(
//                auth -> auth.anyRequest().authenticated()
//        );
        //1.2. decompose security context
        http.authorizeHttpRequests(
                (requests) -> requests
                        .requestMatchers("/tasks/**", "/tasktemplate/**", "/users/**", "/persons/**").authenticated()
                        .requestMatchers("/auth/**", "/vacancies", "/about", "/forStudents", "/forTeachers", "/error").permitAll()
        );

        //2. whenever unauthorized user is trying to reach e.g. "../tasks/1", security will redirect him to the home page.
        http.formLogin(withDefaults());
        //3. show a web page, if a request is not authenticated
        http.httpBasic(/*Customizer.*/withDefaults());
        //4.csrf protection - against fake post/put/delete requests via third-party sites
        //old code (before spring security 6.1)
        //http.csrf().disable();
        //new way using lamba-configuration(expression):
        http.csrf(csrf -> csrf.disable()); //or http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}

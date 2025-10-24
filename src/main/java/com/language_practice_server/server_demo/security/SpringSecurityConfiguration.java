package com.language_practice_server.server_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity  http) throws Exception {
        //all requests on the UI side would be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        //show a web page, if a request is not authenticated
        http.httpBasic(/*Customizer.*/withDefaults());
        //csrf protection - against fake post/put/delete requests via third-party sites
        //old code (before spring security 6.1)
        //http.csrf().disable();
        //new way using lamba-configuration(expression):
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

package com.pmp.restful_web_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // Authenticate all requests
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // Added basic popup to show the login
        httpSecurity.httpBasic(Customizer.withDefaults());

        // Disable CSRF
        httpSecurity.csrf(csrfCustomizer -> csrfCustomizer.disable());

        return httpSecurity.build();
    }
}

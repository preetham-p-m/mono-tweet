package com.pmp.mono_tweet.security;

import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
public class BasicSecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // Authenticate all requests
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated());

        // Added basic popup to show the login
        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.sessionManagement(sessionManagementCustomizer -> sessionManagementCustomizer
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Disable CSRF
        httpSecurity.csrf(csrfCustomizer -> csrfCustomizer.disable());

        return httpSecurity.build();
    }
}

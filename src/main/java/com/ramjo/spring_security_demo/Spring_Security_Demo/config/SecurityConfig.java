package com.ramjo.spring_security_demo.Spring_Security_Demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        return http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .csrf(crsf -> crsf.disable())
                .httpBasic(Customizer.withDefaults()).build();
    }
}

package com.crud.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails ismail = User.builder()
                .username("ismail")
                .password("{noop}ismail123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails obada = User.builder()
                .username("obada")
                .password("{noop}obada123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails osama = User.builder()
                .username("osama")
                .password("{noop}osama123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(ismail, obada, osama);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disaple Cross Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

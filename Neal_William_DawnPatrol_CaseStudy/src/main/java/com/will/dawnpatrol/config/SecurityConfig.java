package com.will.dawnpatrol.config;

import com.will.dawnpatrol.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author willw
 * Configures spring security. Injects the CustomUserDetailsService via constructor injection.
 * Creates a securityFilterChain and Password Encoder to be used in authentication.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    SecurityConfig(CustomUserDetailsService customUserDetailsService){
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * @param http
     * @return
     * @throws Exception
     * Permits user to register or login as well as static files and then requires login for site.
     * Implements the customUserDetailService as its userDetailsService
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        String[] staticResources = {
                "/css/**",
                "/images/**",
                "/fonts/**",
                "/scripts/**",};

        return http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/user/register").permitAll()
                        .requestMatchers(staticResources).permitAll()
                        .anyRequest().authenticated())
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/session/paddle", true)
                .and()
                .userDetailsService(customUserDetailsService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .authorizeHttpRequests()
                .and()
                .logout()
                .and()
                .build();
    }

    /**
     * @return
     * Bcrypt encoder for password encryption.
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

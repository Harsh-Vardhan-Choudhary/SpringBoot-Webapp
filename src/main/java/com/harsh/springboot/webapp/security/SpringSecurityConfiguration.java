package com.harsh.springboot.webapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration 
{
    //either we should use LDPA or Database
    //here we are making use of In Memory

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
        .passwordEncoder(passwordEncoder)
        .username("harsh")
        .password("dummy")
        .roles("USER","ADMIN")
        .build();


        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    //here spring security is encoding the entered passeord with this BCryptPasswordEncoder algorithm 
    //& its not matching whats ever is in userDetail, so when we are configuring user details, 
    //also we would have to make use of that specific algo
}
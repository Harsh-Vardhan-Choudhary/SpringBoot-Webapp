package com.harsh.springboot.webapp.security;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

        UserDetails userDetails1 = createNewUser("kukki", "buddy");
        UserDetails userDetails2 = createNewUser("harsh", "dummy");


        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) 
    {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
        .passwordEncoder(passwordEncoder)
        .username(username)
        .password(password)
        .roles("USER","ADMIN")
        .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    //here spring security is encoding the entered passeord with this BCryptPasswordEncoder algorithm 
    //& its not matching whats ever is in userDetail, so when we are configuring user details, 
    //also we would have to make use of that specific algo

    //we are overriding SecurityFilterChain, we need to define entire chain again
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
        http.formLogin(withDefaults());
        
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }
}
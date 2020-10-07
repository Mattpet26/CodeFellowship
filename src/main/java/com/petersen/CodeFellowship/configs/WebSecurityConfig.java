package com.petersen.CodeFellowship.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .cors().disable()                                  // whitelist pages
                .csrf().disable()                                  // cross site resource forgery
                .authorizeRequests()                               // all lines until AND are connected
                .antMatchers("/").permitAll()           // permit home route
                .antMatchers("/signup", "/login", "/newuser", "/myprofile").permitAll()     // permit them
                .anyRequest().authenticated()                      // forces user to login or authenticate themselves
//                .anyRequest().permitAll()
                .and()
                .formLogin()                                   // settings about login
                .loginPage("/login")                           // login will live on /login + the form must have an action to login
                .defaultSuccessUrl("/")
                .and()
                .logout();                                     // this creates a get route of /logout
    }
}
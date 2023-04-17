package com.ProductsApi.ProductsApi.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration()
public class SecurityConfigs {
    @Bean()
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean()
    public SecurityFilterChain httpConfig(HttpSecurity http) throws Exception{
       return http
               .csrf().disable()
               .cors()
               .and()
               .build();
    }
}

package com.dairyapplication.dairyApplication.config;

import com.dairyapplication.dairyApplication.apputil.PasswordEncrypter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncrypter encoder(){
        return new PasswordEncrypter();
    }
}

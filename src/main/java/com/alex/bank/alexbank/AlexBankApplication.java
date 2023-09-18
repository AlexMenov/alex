package com.alex.bank.alexbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class AlexBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlexBankApplication.class, args);
    }
}

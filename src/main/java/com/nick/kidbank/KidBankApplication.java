package com.nick.kidbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KidBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(KidBankApplication.class, args);
    }

    @Bean
    public Account theAccount() {
        return new Account();
    }
}

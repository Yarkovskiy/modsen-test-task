package com.example.modsentesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ModsenTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModsenTestTaskApplication.class, args);
    }

}

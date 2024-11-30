package com.gian.carrasco.agenda.pro.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);
    }
}
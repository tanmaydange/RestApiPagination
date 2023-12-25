package com.dange.tanmay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class RestAPIPaginationApp {
    public static void main(String[] args) {
        SpringApplication.run(RestAPIPaginationApp.class, args);
        //System.out.println("Hello world!");
    }
}
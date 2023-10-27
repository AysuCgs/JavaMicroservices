package com.aysu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ElasticServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ElasticServiceApp.class);
    }
}
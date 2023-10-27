package com.aysu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class ApiGatewayServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServiceApp.class);
    }
}
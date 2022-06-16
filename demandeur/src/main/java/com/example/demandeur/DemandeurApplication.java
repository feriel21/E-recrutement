package com.example.demandeur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemandeurApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemandeurApplication.class, args);
    }

}

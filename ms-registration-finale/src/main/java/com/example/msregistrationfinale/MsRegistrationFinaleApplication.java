package com.example.msregistrationfinale;



import com.example.msregistrationfinale.domain.Role;
import com.example.msregistrationfinale.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients
public class MsRegistrationFinaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRegistrationFinaleApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "EMOLYEUR"));
            userService.saveRole(new Role(null, "DEMANDEUR"));
            userService.saveRole(new Role(null, "ADMIN"));


        };
    }
}

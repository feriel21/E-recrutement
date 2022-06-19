package com.example.employemanagement;

import com.example.employemanagement.entities.Agence;
import com.example.employemanagement.entities.Employe;
import com.example.employemanagement.repo.AgenceRepo;
import com.example.employemanagement.repo.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployemanagementApplication implements CommandLineRunner {
@Autowired
    EmployeRepo employeRepo ;
@Autowired
    AgenceRepo agenceRepo ;
    public static void main(String[] args) {
        SpringApplication.run(EmployemanagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* Agence a1= agenceRepo.findById(1L).get();
        a1.setAgence(String.valueOf(new Agence(null , "agence1")));
        agenceRepo.save(a1);*/
       agenceRepo.save(
                new Agence(null , "agence1"))  ;


    }


}

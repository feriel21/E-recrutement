package com.example.demandeur.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String emp_name ;
    private String ActivityPrincipale ;
    private String emp_address ;
    private String emp_email ;
}

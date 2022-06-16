package com.example.employemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
    private String nom ;
    private String  prenom ;
    private String email ;
    private String numTel ;
}

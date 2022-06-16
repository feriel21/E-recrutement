package com.example.employemanagement.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {
    private String rue;
    private Integer numero;
    private String codePostal;
    private String  ville;
    private String Commune ;
}


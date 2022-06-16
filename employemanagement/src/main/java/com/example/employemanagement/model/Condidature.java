package com.example.employemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condidature {
    private Long idCondidature  ;
    private String libelle;

    private Collection<Cv> cv;
}

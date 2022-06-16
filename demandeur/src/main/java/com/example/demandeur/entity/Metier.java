package com.example.demandeur.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetier;
    @Column(nullable = false, length = 20)
    private String libelle;

}

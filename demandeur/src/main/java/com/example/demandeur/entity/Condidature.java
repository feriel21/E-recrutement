package com.example.demandeur.entity;

import com.example.demandeur.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Condidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCondidature;

    @Column(nullable = false)
    private String libelle;
   /* @ManyToMany
    private Collection<Cv> cv;*/
   @ManyToOne
   private Cv cv;


    @Transient
private List<Offer> offers ;




}

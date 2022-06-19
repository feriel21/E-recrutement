package com.example.demandeur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NiveauxQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveauxQ;
    @Column(nullable = false, length = 20)
    private String libelle;
    @ManyToOne
    private Cv cv;

}

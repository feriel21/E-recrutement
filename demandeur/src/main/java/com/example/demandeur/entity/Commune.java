package com.example.demandeur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommune;
    @Column(nullable = false, length = 20)
    private String libelle;
    @ManyToOne
    @JoinColumn(name="idWilaya")
    private  Wilaya wilaya ;

}

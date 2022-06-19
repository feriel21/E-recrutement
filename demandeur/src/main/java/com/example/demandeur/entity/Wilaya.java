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
public class Wilaya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWilaya;
    @Column(nullable = false, length = 20)
    private String libelle;
   @OneToMany(mappedBy = "wilaya")
    private Collection<Commune> commune;
}

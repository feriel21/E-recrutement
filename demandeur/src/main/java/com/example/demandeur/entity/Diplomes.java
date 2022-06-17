package com.example.demandeur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "Diplomes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Diplomes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiplome;
    private String lieu;
    @Temporal(TemporalType.DATE)
    private Date dateObtention;

    @ManyToMany
      private Collection<Cv> cv;

   @OneToOne(mappedBy = "diplome" ,   cascade = CascadeType.PERSIST)
    private Specialite specialite;

    @OneToOne(mappedBy = "diplome")
    private Option option;

    @OneToOne(mappedBy = "diplome")
    private Filiere filiere;
}

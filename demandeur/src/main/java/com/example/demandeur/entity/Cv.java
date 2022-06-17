package com.example.demandeur.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCv;
    private String nom ;
    private String prenom ;

    @Column(unique = true,length = 10)
    private int NumTel;

    @Column(unique = true)
    private String email;

    @Transient
    private int age;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private Competence competence;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Enumerated(EnumType.STRING)
    private PermisDeConduit Permis;

    @Enumerated(EnumType.STRING)
    private SituationFam SituationFamiliale;

    private  boolean Handicap;

    @Enumerated(EnumType.STRING)
    private SituationMilitaire SituationMilitaire;

    private String adresse;



    @JsonIgnore
    @ManyToMany(mappedBy = "cv", fetch = FetchType.EAGER)
    private Collection<Diplomes> Diplomes;

    private Langues Langues;


    private NiveauxQualification Niveaux;

    @JsonIgnore
    @ManyToMany(mappedBy = "cv")
    private Collection<FormationPro> FormationPro;

    @ManyToMany(mappedBy = "cv")
    private Collection<Condidature> condidature;

    @JsonIgnore
    @OneToOne
    private Demandeur Demandeur;


}
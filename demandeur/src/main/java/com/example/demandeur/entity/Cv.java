package com.example.demandeur.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCv;

    @Column(unique = true,length = 10)
    private int NumTel;

    @Column(unique = true)
    private String email;

    @Transient
    private int age;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Enumerated(EnumType.STRING)
    private PermisDeConduit Permis;

    @Enumerated(EnumType.STRING)
    private SituationFam SituationFamiliale;

    private  boolean Handicap;

    @Enumerated(EnumType.STRING)
    private Sexe SituationMilitaire;

    private String adresse;

   /* @JsonIgnore
    @ManyToMany(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Diplomes> Diplomes;*/


    @JsonIgnore
    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Diplomes> diplomes;

   /* @JsonIgnore
    @ManyToMany(mappedBy = "cv")
    private Collection<Langues> Langues;*/

    @JsonIgnore
    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Langues> langues;

   /* @JsonIgnore
    @ManyToMany(mappedBy = "cv")
    private Collection<NiveauxQualification> Niveaux;*/
   @JsonIgnore
   @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private Collection<NiveauxQualification> niveauxQualifications;

    /*@JsonIgnore
    @ManyToMany(mappedBy = "cv")
    private Collection<FormationPro> FormationPro;*/

    @JsonIgnore
    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<FormationPro> formationPros ;

    /*@ManyToMany(mappedBy = "cv")
    private Collection<Condidature> condidature;*/

    @JsonIgnore
    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Condidature> condidatures;

    @JsonIgnore
    @OneToOne
    private Demandeur Demandeur;
}
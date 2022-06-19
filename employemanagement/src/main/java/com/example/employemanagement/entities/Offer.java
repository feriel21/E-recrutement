package com.example.employemanagement.entities;

import com.example.employemanagement.model.Condidature;
import com.example.employemanagement.model.Diplomes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffer;
    private String offerTitle;
    //relation employe

    @Embedded
    private Adresse adresseOffer;
    @Enumerated(EnumType.STRING)
    private Metier metier;
    private String experience;


    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Transient
    private int MinAge;
    @Transient
    private int MaxAge;
    private String competence;
    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;
    @Enumerated(EnumType.STRING)
    private EtatOffer etatOffer;

    private String naturePoste;
    @Enumerated(EnumType.STRING)
    private Langue langue;
    @Enumerated(EnumType.STRING)
    private Hebergement hebergement;
    @Enumerated(EnumType.STRING)
    private Restauration restauration;
    @Enumerated(EnumType.STRING)
    private Transport transport;

    private Long salaire;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idEmploye")
    private Employe employe;


    private Long idCondidature;
    private Long idDiplome ;


    @Enumerated(EnumType.STRING)
    @Transient
    private Condidature condidature;
    @Enumerated(EnumType.STRING)
   @Transient
    private Diplomes diplomes ;



}

package com.example.employemanagement.entities;

import com.example.employemanagement.model.Condidature;
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
    private String agence;
    @Embedded
    private Adresse adresseOffer;

    private Metier metier;
    private String experience;


    private Genre genre;
    @Transient
    private int MinAge;
    @Transient
    private int MaxAge;
    private String competence;

    private TypeContrat typeContrat;

    private EtatOffer etatOffer;

    private String naturePoste;

    private Langue langue;

    private Hebergement hebergement;

    private Restauration restauration;

    private Transport transport;

    private Long salaire;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idEmploye")
    private Employe employe;


    private Long idCondidature;



    @Transient
    private Condidature condidature;




}

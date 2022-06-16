package com.example.employemanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    private String nom;



    private String agence ;


    private Long numRegistreComerciale ;
    @Temporal(TemporalType.DATE)


    private Date dateInscription;


  private String activityPrincipale  ;


    private String activitySecondaire ;





    private String statusJuridique ;


    private String brancheActivity ;


    private String respRecrutement ;


    @Embedded
    private Adresse adresse;


    private String email ;


    private Long numTel ;


    private Long fax ;


    private boolean active ;


    @OneToMany(mappedBy = "employe")
    private Collection<Offer> Lesoffers;


}

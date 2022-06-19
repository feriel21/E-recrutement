package com.example.employemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diplomes {


    private Long idDiplome;
    private String lieu;
    @Temporal(TemporalType.DATE)
    private Date dateObtention;

    @ManyToMany
    private Collection<Cv> cv;



}

package com.example.employemanagement.repo;

import com.example.employemanagement.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface EmployeRepo extends JpaRepository<Employe, Long> {


    Employe findEmployeByNom(String nom);
    Employe findEmployeByIdEmploye(Long idEmploye) ;
    //List<Employe> findByNomOrActivityPrincipale(String nom , String activityPrincipale) ;



    @Query("select e from Employe e where lower(e.nom) like lower(concat('%', :search, '%')) " +
            "or lower(e.activityPrincipale) like lower(concat('%', :search, '%'))")
    List<Employe> findByNomOrActivityPrincipale(@Param("search") String search);




    @Override
    List<Employe> findAll();



}







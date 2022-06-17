package com.example.demandeur.controller;

import com.example.demandeur.entity.Condidature;
import com.example.demandeur.entity.Cv;
import com.example.demandeur.entity.Diplomes;
import com.example.demandeur.repo.DiplomesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api-diplomes")
public class DiplomesController {
    @Autowired
    DiplomesRepo diplomesRepo ;


    @GetMapping("/{id}")
    public Diplomes getDiplomes(@PathVariable("id") Long idDiplome){
        return diplomesRepo.findDiplomesByIdDiplome(idDiplome) ;
    }




    @PostMapping("/ajouterDiplome")  //POST http://localhost:8081/api/condidature
    public Diplomes createNewDiplomes(@RequestBody Diplomes diplomes) {
        return diplomesRepo.save(diplomes);
    }


    @DeleteMapping("/deleteDiplome/{id}")   //Delete http://localhost:8081/api/condidature/1
    public String DeleteDiplomes(@PathVariable(value = "id") Long idDiplome){
        if (diplomesRepo.findById(idDiplome).isPresent()){
            diplomesRepo.deleteById(idDiplome);
            return "condidature a supprimer";}
        return "the ID is not valid";
    }



}

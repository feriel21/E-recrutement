package com.example.demandeur.controller;

import com.example.demandeur.entity.Diplomes;
import com.example.demandeur.entity.FormationPro;
import com.example.demandeur.repo.DiplomesRepo;
import com.example.demandeur.repo.FormationProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api-formationPro")
public class FormationProController {
    @Autowired
    FormationProRepo formationProRepo ;


    @GetMapping("/{id}")
    public FormationPro getFormationPro(@PathVariable("id") Long idFormationPro){
        return formationProRepo.findFormationProByIdFormationPro( idFormationPro) ;
    }




    @PostMapping("/ajouterFormationPro")  //POST http://localhost:8081/api/condidature
    public FormationPro createNewFormationPro(@RequestBody FormationPro formationPro) {
        return formationProRepo.save(formationPro);
    }


    @DeleteMapping("/deleteFormationPro/{id}")   //Delete http://localhost:8081/api/condidature/1
    public String DeleteFormationPro(@PathVariable(value = "id") Long idFormationPro){
        if (formationProRepo.findById(idFormationPro).isPresent()){
            formationProRepo.deleteById(idFormationPro);
            return "condidature a supprimer";}
        return "the ID is not valid";
    }



}

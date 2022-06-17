package com.example.demandeur.controller;

import com.example.demandeur.entity.Demandeur;
import com.example.demandeur.repo.DemandeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class DemandeurController {

    @Autowired
    DemandeurRepo demandeurRepo;

    @GetMapping("/demandeur/{id}")
    Demandeur getDemandeur(@PathVariable("id") Long idDemandeur) {
       Demandeur demandeur = demandeurRepo.findById(idDemandeur).get();
        return demandeur;
    }

        @GetMapping("/demandeur")  //GET http://localhost:8081/api/demandeur?id=1
        public List<Demandeur> getDemandeurs() {
            return demandeurRepo.findAll();
        }

        @PostMapping("/demandeur")  //POST http://localhost:8081/api/demandeur
        public Demandeur createNewDemandeur(@RequestBody Demandeur demandeur) {
            return demandeurRepo.save(demandeur);
        }


        @PutMapping("/client/{id}")  //Put http://localhost:8081/api/demandeur/1
        public Demandeur updateDemandeur(@PathVariable(value = "id") Long idDemandeur,
                                   @RequestBody Demandeur demandeur) {
            if (demandeurRepo.findById(idDemandeur).isPresent()) {
                demandeur.setIdDemandeur(idDemandeur);
                return demandeurRepo.save(demandeur);
            }
            return null;
        }



    @DeleteMapping("/deleteDemandeur/{id}")

    public String DeleteDemandeur(@PathVariable(value = "id") Long idDomandeur){

        if (demandeurRepo.findById(idDomandeur).isPresent()){
            demandeurRepo.deleteById(idDomandeur);
            return "Correctly deleted";}
        return "the ID is not valid";
    }




    // @GetMapping("/condidature/{id_offre}")  //GET http://localhost:8081/api/condidature?id_offre=1
 //   public List<Demandeur> getDemandeurs() {
    //    return DemandeurRepo.findAll();
  //  }

}

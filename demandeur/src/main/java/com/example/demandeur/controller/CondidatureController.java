package com.example.demandeur.controller;

import com.example.demandeur.entity.Condidature;
import com.example.demandeur.proxies.OfferProxy;
import com.example.demandeur.repo.CondidatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")

public class CondidatureController {
    @Autowired
    CondidatureRepo CondidatureRepo;

    @Autowired
    OfferProxy offerProxy ;

    @GetMapping("condidature/{id}")
    Condidature getCondidatureWithOffers(@PathVariable("id") Long idC)
    {
        Condidature condidature=CondidatureRepo.findById(idC).get();
        condidature.setOffers(
                new ArrayList<>(offerProxy.getOffers(idC,"todemandeur").getContent()));
        return condidature;
    }









    @PostMapping("/condidature")  //POST http://localhost:8081/api/condidature
    public Condidature createNewClient(@RequestBody Condidature condidature) {
        return CondidatureRepo.save(condidature);
    }





    @DeleteMapping("/condidature/{id}")   //Delete http://localhost:8081/api/condidature/1
    public String DeleteCondidature(@PathVariable(value = "id") Long idCondidature){
        if (CondidatureRepo.findById(idCondidature).isPresent()){
           CondidatureRepo.deleteById(idCondidature);
            return "condidature a supprimer";}
        return "the ID is not valid";
    }
}

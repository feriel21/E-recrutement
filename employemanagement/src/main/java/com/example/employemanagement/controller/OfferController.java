package com.example.employemanagement.controller;

import com.example.employemanagement.entities.Employe;
import com.example.employemanagement.entities.Metier;
import com.example.employemanagement.entities.Offer;
import com.example.employemanagement.proxies.CondidatureProxy;
import com.example.employemanagement.repo.OfferRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("offer-api")
public class OfferController {
    private final Logger log = LoggerFactory.getLogger(OfferController.class);
    @Autowired
    OfferRepo offerRepo;

    @Autowired
    CondidatureProxy condidatureProxy;



   @GetMapping("offer/{id}/condidature")
    Offer getOfferWithCondidature(@PathVariable("id") Long idO)    {
        Offer offer =offerRepo.findById(idO).get();
        offer.setCondidature(condidatureProxy.getCondidature(offer.getIdCondidature()));
        return offer;
    }




   @GetMapping("offer/condidature")
    List<Offer> getOffers()
    {
        List<Offer> offers=offerRepo.findAll();

        offers.forEach((e)->{
            e.setCondidature(condidatureProxy.getCondidature(e.getIdCondidature()));
        });

        return  offers;
    }


  /*  @GetMapping("/offer/all")
    public List<Offer> getOffers(){return offerRepo.findAll() ; }*/



    @GetMapping("/offer/{metier}") //GET http://localhost:8090/employe-api/employe/ent1
    public Offer getOfferByMetier(@PathVariable("metier") Metier metier){

        return offerRepo.findOfferByMetier(metier) ;
    }


    //POST http://localhost:8090/offer-api/ajouterOffer
    @RequestMapping(value = "/ajouterOffer", method = RequestMethod.POST)
    public Offer createNewOffer(@RequestBody Offer offer) {
        return offerRepo.save(offer);
    }


    @PutMapping("/offer/{id}")
    public Offer updateOffer(@PathVariable(value = "id") Long id,
                                 @RequestBody Offer offer) {
        if (offerRepo.findById(id).isPresent()) {
            offer.setIdOffer(id);
            return offerRepo.save(offer) ;
        }
        return null;
    }



    @DeleteMapping("/deleteOffer/{id}")

    public String DeleteOffer(@PathVariable(value = "id") Long idOffer){

        if (offerRepo.findById(idOffer).isPresent()){
            offerRepo.deleteById(idOffer);
            return "Correctly deleted";}
        return "the ID is not valid";
    }





    @RequestMapping(value = "/searchOffer" , method =RequestMethod.GET )
    public List<Offer> getOfferByOfferTitleOrMetier(@RequestParam(name = "search")  String search, Model model)  {
        List<Offer> offer = offerRepo.findOfferByOfferTitleOrMetier(search);
        model.addAttribute("offers", offer);
        return offerRepo.findOfferByOfferTitleOrMetier(search) ;
    }







}

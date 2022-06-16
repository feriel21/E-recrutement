package com.example.demandeur.proxies;

import com.example.demandeur.model.Offer;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="employemanagement")
@LoadBalancerClient(name="employemanagement")
public interface OfferProxy {

    @GetMapping("/offers/search/findOfferByIdCondidture")
    CollectionModel<Offer> getOffers(@RequestParam("idC") Long idC,
                                     @RequestParam("projection") String p);




}

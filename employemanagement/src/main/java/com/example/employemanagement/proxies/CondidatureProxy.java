package com.example.employemanagement.proxies;



import com.example.employemanagement.model.Condidature;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="demandeur")
@LoadBalancerClient(name="demandeur",configuration = LBConfiguration.class)

public interface CondidatureProxy {


    @GetMapping("/condidature/{id}")
    Condidature getCondidature(@PathVariable("id") Long idC);

}










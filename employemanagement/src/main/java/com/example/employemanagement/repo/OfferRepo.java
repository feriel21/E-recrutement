package com.example.employemanagement.repo;

import com.example.employemanagement.entities.Metier;
import com.example.employemanagement.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OfferRepo extends JpaRepository<Offer, Long> {


    Offer findOfferByMetier(Metier metier);

    @Override
    List<Offer> findAll();


    List<Offer> findOfferByIdCondidature(Long idC);




    @Query("select o from Offer o where lower(o.offerTitle) like lower(concat('%', :search, '%')) " +
            "or lower(o.metier) like lower(concat('%', :search, '%'))")
    List<Offer> findOfferByOfferTitleOrMetier(@Param("search") String search);



}

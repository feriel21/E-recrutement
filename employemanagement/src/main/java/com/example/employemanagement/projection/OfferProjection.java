package com.example.employemanagement.projection;

import com.example.employemanagement.entities.Offer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Component;

@Component
@Projection(name="todemandeur", types= Offer.class)
public interface OfferProjection {
         Long getidOffer();

        @Value("#{target.offer.offerTitle}")
        String getOfferTitle();

        @Value("#{target.adresse.ville}")
        String getCity();

    }


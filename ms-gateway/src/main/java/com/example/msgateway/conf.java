package com.example.msgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class conf {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("route1", r -> r.path("/demandeur/(?<s>.*), /${s}")
                        .uri("lb://demandeur"))
                .route("route2" , r -> r.path("/employe/(?<s>.*), /${s}")
                        .uri("lb://employemanagement"))





                .build() ;

    }
}
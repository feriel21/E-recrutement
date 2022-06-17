package com.example.msgateway;

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
                .route("route3" , r -> r.path("/user/(?<s>.*), /${s}")
                        .uri("lb://ms-registration-finale"))




                .build() ;

    }
}
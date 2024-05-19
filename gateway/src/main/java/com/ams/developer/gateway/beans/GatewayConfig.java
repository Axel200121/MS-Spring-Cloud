package com.ams.developer.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayConfig {

    @Bean
    @Profile(value = "eureka-off")
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                .route(route -> route.path("/companies-crud/company/**").uri("http://localhost:8081"))
                .route(route -> route.path("/report-ms/report/**").uri("http://localhost:7070"))
                .build();
    }

    //TODO: ESTA FUNCIÓN SERA CUANDO QUEREAMOS DAR PUERTOS RANDOM A LOS MS
    @Bean
    @Profile(value = "eureka-on")
    public RouteLocator routeLocatorEurekaOn(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                .route(route -> route.path("/companies-crud/company/**").uri("lb://companies-crud"))
                .route(route -> route.path("/report-ms/report/**").uri("lb://report-ms"))
                .build();
    }
}

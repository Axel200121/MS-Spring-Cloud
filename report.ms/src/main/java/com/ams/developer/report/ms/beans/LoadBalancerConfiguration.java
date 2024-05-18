package com.ams.developer.report.ms.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context){
        log.info("CONFIGURANDO EL LOAD BALANCER");
        return ServiceInstanceListSupplier
                .builder()
                .withBlockingDiscoveryClient()
                .build(context);
    }
}

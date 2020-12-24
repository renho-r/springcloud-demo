package com.renho.springcloud.demo.gateway.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(excludeFilters =
        {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.renho.springcloud.demo.gateway.registry.config.*")
        })
public class RegistryGatewayApplication {

    public static void main( String[] args ) {
//        HandlerMapping
//        RouteDefinitionLocator
        SpringApplication.run(RegistryGatewayApplication.class, args);
    }

}

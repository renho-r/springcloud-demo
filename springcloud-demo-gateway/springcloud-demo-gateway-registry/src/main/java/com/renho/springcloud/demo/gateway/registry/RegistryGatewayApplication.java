package com.renho.springcloud.demo.gateway.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
public class RegistryGatewayApplication {

    public static void main( String[] args ) {
//        HandlerMapping
//        RouteDefinitionLocator
        SpringApplication.run(RegistryGatewayApplication.class, args);
    }

}

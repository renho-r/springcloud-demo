package com.renho.springcloud.demo.gateway.noregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;

/**
 * @author renho
 * @date 2020/12/22
 */
@SpringBootApplication
public class NoRegistryGatewayApplication {
    public static void main(String[] args) {
//        RouteLocator
//        RouteDefinitionLocator
//        GlobalFilter
//        GatewayFilter
        SpringApplication.run(NoRegistryGatewayApplication.class, args);
    }
}

package com.renho.springcloud.demo.gateway.registry.route.config;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author renho
 * @date 2020/12/24
 */

@Component
public class MyRouteDefinitionRepository implements RouteDefinitionRepository {

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {

        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId("path_route_lb");
        routeDefinition.setUri(URI.create("lb://my-ribbon-httpbin"));

        List<PredicateDefinition> predicates = new ArrayList<>();
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        predicateDefinition.addArg("Path", "/anything/anything/renho");
        predicates.add(predicateDefinition);
        routeDefinition.setPredicates(predicates);

        List<FilterDefinition> filters = new ArrayList<>();
        FilterDefinition filterDefinition = new FilterDefinition();
        filterDefinition.setName("StripPrefix");
        filterDefinition.addArg("parts", "1");
        filters.add(filterDefinition);
        routeDefinition.setFilters(filters);

        routeDefinitions.add(routeDefinition);

        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        System.out.println("save");
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        System.out.println("delete");
        return null;
    }
}


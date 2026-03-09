package com.rays.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Spring Cloud Gateway routes.
 * 
 * This class defines routing rules that forward incoming HTTP requests
 * to appropriate microservices registered in the service registry
 * (e.g., Eureka) using load-balanced URIs.
 */
@Configuration
public class GatewayConfig {

    /**
     * Creates and configures the RouteLocator bean.
     * 
     * The RouteLocator defines how incoming requests are routed to
     * backend microservices.
     *
     * Routes:
     * - Requests starting with /service01/** are routed to the service
     *   registered with name "service01".
     * - Requests starting with /service02/** are routed to the service
     *   registered with name "service02".
     *
     * The "lb://" prefix enables client-side load balancing via
     * Spring Cloud LoadBalancer.
     *
     * @param builder RouteLocatorBuilder used to construct gateway routes
     * @return configured RouteLocator instance
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("service01",
                r -> r.path("/service01/**")
                      .uri("lb://service01"));

        routes.route("service02",
                r -> r.path("/service02/**")
                      .uri("lb://service02"));

        return routes.build();
    }
}

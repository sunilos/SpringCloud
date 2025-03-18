package com.sunilos.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GatewayConfig class is responsible for defining microservice routing in the API Gateway.
 * It routes incoming client requests to respective microservices using their service names 
 * registered with the discovery server (e.g., Eureka).
 * <p>
 * This configuration dynamically forwards API requests based on defined paths.
 * For example:
 * - Requests to "/order-service/**" will be forwarded to the "order-service" microservice.
 * - Requests to "/inventory-service/**" will be forwarded to the "inventory-service" microservice.
 * - Requests to "/payment-service/**" will be forwarded to the "payment-service" microservice.
 * </p>
 * <p>
 * The {@code stripPrefix(1)} filter is used to remove the first path segment before forwarding 
 * the request to the respective microservice.
 * </p>
 *
 * <h3>Example Requests:</h3>
 * <pre>
 * Request: GET http://localhost:8080/order-service/details
 * Forwarded To: http://order-service/details
 * 
 * Request: GET http://localhost:8080/inventory-service/check
 * Forwarded To: http://inventory-service/check
 * 
 * Request: POST http://localhost:8080/payment-service/process
 * Forwarded To: http://payment-service/process
 * </pre>
 *
 * @author SunilOS
 * @version 1.0
 * @since 2025-03-17
 */

@Configuration
public class GatewayConfig {

    /**
     * Defines custom route mappings for the API Gateway.
     * This method registers routes for microservices, using service names registered in the discovery server.
     * Load balancing is enabled using `lb://service-name` which delegates traffic via Eureka Service Discovery.
     *
     * @param builder {@link RouteLocatorBuilder} for defining routes
     * @return {@link RouteLocator} with configured routes
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("order-service",
                r -> r.path("/order-service/**")
                    .filters(f -> f.stripPrefix(1)) // Removes "/order-service" prefix before forwarding
                    .uri("lb://order-service")) // Routes request to the "order-service"

            .route("inventory-service",
                r -> r.path("/inventory-service/**")
                    .filters(f -> f.stripPrefix(1)) // Removes "/inventory-service" prefix before forwarding
                    .uri("lb://inventory-service")) // Routes request to the "inventory-service"

            .route("payment-service",
                r -> r.path("/payment-service/**")
                    .filters(f -> f.stripPrefix(1)) // Removes "/payment-service" prefix before forwarding
                    .uri("lb://payment-service")) // Routes request to the "payment-service"

            .build();
    }
}

package com.sunilos.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * <h1>API Gateway - Central Routing Service</h1>
 * <p>
 * The {@code ApiGatewayApplication} class serves as the **API Gateway** in a 
 * **Spring Cloud Microservices Architecture**. It acts as a **single point of entry** 
 * for all client requests and routes them to the respective microservices.
 * </p>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *     <li>Implements **Spring Cloud Gateway** for intelligent request routing.</li>
 *     <li>Uses **Eureka Discovery Client** for dynamic service discovery.</li>
 *     <li>Handles **CORS (Cross-Origin Resource Sharing)** for frontend applications.</li>
 * </ul>
 * 
 * <h3>Service Routing:</h3>
 * <p>
 * The API Gateway dynamically routes incoming requests to the appropriate 
 * microservices based on defined **routes** in the configuration.
 * </p>
 * 
 * <h3>Example API Requests:</h3>
 * <pre>
 * GET http://localhost:8080/order-service/details
 * (Forwarded to the "order-service")
 *
 * GET http://localhost:8080/payment-service/process
 * (Forwarded to the "payment-service")
 * </pre>
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-03-17
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    /**
     * The main entry point for the Spring Boot application.
     * This method launches the API Gateway service, allowing it to route client requests.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    /**
     * Configures **CORS (Cross-Origin Resource Sharing)** settings to allow cross-domain requests.
     * This is particularly useful when the frontend application (e.g., Angular, React) 
     * runs on a different domain or port than the API Gateway.
     * 
     * <h3>Configured CORS Rules:</h3>
     * <ul>
     *     <li>Allows requests from "http://localhost:4200" (Frontend App).</li>
     *     <li>Permits all headers and methods.</li>
     *     <li>Supports credentials (cookies, authorization tokens).</li>
     * </ul>
     * 
     * @return A {@link CorsWebFilter} bean that applies the CORS configuration to all routes.
     */
    
    /*
    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowCredentials(true);

        // Explicitly allow the frontend origin
        corsConfig.addAllowedOrigin("http://localhost:4200");

        // Permit all headers and methods
        corsConfig.addAllowedHeader("*");
        corsConfig.addAllowedMethod("*");

        // Apply the configuration to all API endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
    */
}

package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main entry point for the Inventory Service application.
 * 
 * <p>This microservice is responsible for managing inventory-related operations
 * in a distributed system. It is registered with a discovery server (e.g., Eureka)
 * and communicates with other services using Feign clients.</p>
 * 
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Spring Boot-based microservice</li>
 *   <li>Service discovery using Eureka</li>
 *   <li>Inter-service communication via Feign Clients</li>
 * </ul>
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class InventoryServiceApplication {

    /**
     * Main method that starts the Inventory Service application.
     * 
     * @param args Command-line arguments.
     */
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
}

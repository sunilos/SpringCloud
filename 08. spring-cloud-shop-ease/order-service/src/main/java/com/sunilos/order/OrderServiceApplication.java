package com.sunilos.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The {@code OrderServiceApplication} class serves as the entry point for the Order Service
 * application. It is a Spring Boot application that leverages Feign clients for communication
 * and registers itself with a discovery server.
 * 
 * <p>
 * Annotations used:
 * <ul>
 *   <li>{@link SpringBootApplication} - Marks this class as a Spring Boot application.</li>
 *   <li>{@link EnableFeignClients} - Enables Feign clients for making HTTP requests to other services.</li>
 *   <li>{@link EnableDiscoveryClient} - Allows this service to register with a service discovery provider.</li>
 * </ul>
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2025-03-15
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OrderServiceApplication {

    /**
     * The main method that serves as the entry point for the Spring Boot application.
     *
     * @param args Command-line arguments passed during application startup.
     */
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}

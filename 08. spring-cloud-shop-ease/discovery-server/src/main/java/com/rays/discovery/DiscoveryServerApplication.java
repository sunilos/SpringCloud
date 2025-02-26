package com.rays.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring Cloud Discovery Server is a service registry that helps microservices
 * discover each other dynamically. It is commonly implemented using Netflix
 * Eureka Server as part of the Spring Cloud Netflix stack.
 * 
 * Main class for the Eureka Discovery Server. This service will act as a
 * service registry for microservices.
 */
@SpringBootApplication // Marks this as a Spring Boot application
@EnableEurekaServer // Enables this application as a Eureka Server
public class DiscoveryServerApplication {

	/**
	 * Main method to start the Discovery Server.
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args); // Bootstraps the Eureka Server
	}
}

package com.sunilos.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main entry point for the Payment Service application.
 * 
 * <p>This microservice is responsible for handling payment transactions
 * within a distributed system. It is registered with a service discovery
 * server (e.g., Eureka) and uses Feign clients for inter-service communication.</p>
 * 
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Spring Boot-based microservice</li>
 *   <li>Service discovery using Eureka</li>
 *   <li>Inter-service communication via Feign Clients</li>
 *   <li>Handles payment transactions securely</li>
 * </ul>
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PaymentServiceApplication {

    /**
     * Main method that starts the Payment Service application.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}

package com.rays.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The ConfigServerApplication class serves as the entry point for the Spring Boot application.
 * It enables the Config Server functionality, which allows centralized configuration management 
 * for distributed systems.
 * 
 * <p>
 * This application uses Spring Cloud Config Server to provide externalized configuration
 * to various microservices.
 * </p>
 * 
 * @author SunilOS
 * @version 1.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {

    /**
     * The main method is the entry point of the Spring Boot application.
     * It bootstraps the application using {@link SpringApplication#run(Class, String...)}.
     * 
     * @param args command-line arguments passed during application startup
     */
    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApplication.class, args);

    }

}

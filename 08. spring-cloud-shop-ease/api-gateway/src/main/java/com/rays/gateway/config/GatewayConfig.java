package com.rays.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * It defines microservice routers. It routes requests to respective
 * microservice using service name regsitered at discovery server. For example
 * service01, service02, and ORS10 are names registered with discovery server.
 * 
 */

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes().route("order-service", r -> r.path("/order-service/**").uri("lb://order-service"))
				.route("inventory-service", r -> r.path("/inventory-service/**").uri("lb://inventory-service"))
				.route("payment-service", r -> r.path("/payment-service/**").uri("lb://payment-service")).build();
	}
}

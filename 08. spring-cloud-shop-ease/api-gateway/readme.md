
# 🌐 API Gateway - Spring Cloud Gateway with Eureka

This project implements a **Spring Cloud API Gateway** that acts as a **single entry point** for routing client requests to microservices registered with a **Discovery Server (Eureka)**.

---

## 🚀 Overview

- **Framework**: Spring Boot, Spring Cloud Gateway
- **Discovery**: Eureka Client enabled
- **Architecture**: Microservices (Gateway + Multiple Services)
- **Web Stack**: Reactive (WebFlux)

---

## 🧩 Key Components

### 🔸 `ApiGatewayApplication.java`
Located at: `com.sunilos.gateway`

```java
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    // CORS configuration bean
    @Bean
    public CorsWebFilter corsWebFilter() {
        ...
    }
}
```

- Uses `@EnableDiscoveryClient` to register with Eureka.
- Sets up a **CORS filter** to allow cross-origin requests.

---

### 🔸 `GatewayConfig.java`
Located at: `com.sunilos.gateway.config`

```java
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("order-service", r -> r.path("/order-service/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://order-service"))
            .route("inventory-service", r -> r.path("/inventory-service/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://inventory-service"))
            .route("payment-service", r -> r.path("/payment-service/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://payment-service"))
            .build();
    }
}
```

- Routes requests to microservices based on path.
- `stripPrefix(1)` removes the base path before forwarding.

---

### 🔸 `application.yml`

```yaml
server:
  host: localhost
  port: 8080

spring:
  application:
    name: api-gateway
  main:
    web-application-type: reactive
  config:
    import: configserver:http://localhost:8888

logging:
  level:
    org.springframework.cloud.gateway: DEBUG
    reactor.netty.http.client: DEBUG
```

- Runs gateway on port **8080**.
- Fetches config from Spring Cloud Config Server.
- Enables detailed debug logging for troubleshooting.

---

## 🧑‍💻 For Beginners

1. Clone the repo:
   ```bash
   git clone https://github.com/your-org/api-gateway.git
   cd api-gateway
   ```

2. Ensure that Eureka Discovery Server and Config Server are running.

3. Run the Gateway:
   ```bash
   mvn spring-boot:run
   ```

4. Test endpoints like:
   ```
   http://localhost:8080/inventory-service/ctl/inventory
   http://localhost:8080/payment-service/ctl/payment
   http://localhost:8080/order-service/ctl/orders
   ```

---

## 🧠 For Advanced Users

- Implement **rate limiting**, **authentication**, or **circuit breakers** with Spring Cloud Gateway filters.
- Configure CORS headers globally or per route.
- Use `RouteLocatorBuilder` for dynamic route building.
- Secure gateway with OAuth2 or JWT tokens for API authentication.
- Enable monitoring via Spring Boot Actuator endpoints.

---

## 📘 References

- [Spring Cloud Gateway Docs](https://cloud.spring.io/spring-cloud-gateway/)
- [Spring Boot WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)
- [Netflix Eureka](https://github.com/Netflix/eureka)


# 📦 Inventory Microservice - Spring Boot

This project is a part of a **Spring Cloud Microservices architecture**, focused on managing inventory operations. The service is registered with **Eureka Discovery Server** and integrates with **Spring Cloud Config Server** for centralized configuration.

---

## 🚀 Overview

- **Framework**: Spring Boot
- **Discovery**: Eureka Client
- **Configuration**: Spring Cloud Config Server
- **Communication**: Feign Clients (for inter-service calls)

---

## 🧩 Key Components

### 🔸 `InventoryServiceApplication.java`

```java
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
}
```

- Bootstraps the Inventory Service.
- Registers with **Eureka** for service discovery.
- Enables **Feign Clients** for remote service communication.

---

### 🔸 `InventoryCtl.java`

```java
@RestController
@RequestMapping(value = {"ctl/inventory"})
public class InventoryCtl {

    @Value(value = "100")
    private int stock;

    @PostMapping("/update")
    public int updateStock(@RequestParam("qty") int qty) {
        stock = stock - qty;
        return stock;
    }

    @GetMapping("/check")
    public int checkStock() {
        return stock;
    }
}
```

- Exposes REST endpoints to:
  - **Check available stock**: `GET /ctl/inventory/check`
  - **Update stock** after a sale: `POST /ctl/inventory/update?qty=5`

---

### 🔸 `application.yml`

```yaml
server:
  port: 8081

spring:
  application:
    name: inventory-service
  config:
    import: configserver:http://localhost:8888
```

- The service runs on **port 8081**.
- Registers as `inventory-service` in Eureka.
- Fetches configuration from **Spring Cloud Config Server**.

---

## 🧑‍💻 For Beginners

### 🧪 Test Endpoints

1. **Check Stock**  
   ```
   curl http://localhost:8081/ctl/inventory/check
   ```

2. **Update Stock**  
   ```
   curl -X POST http://localhost:8081/ctl/inventory/update?qty=10
   ```

---

## 🧠 For Advanced Users

- Integrate with **Order Service** to automatically reduce inventory on purchase.
- Add **JPA & DB persistence** for inventory data.
- Use **FeignClient** to call other microservices.
- Implement **circuit breakers** using Resilience4j or Hystrix.
- Monitor endpoints using **Spring Boot Actuator**.

---

## 📘 References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)
- [Spring Cloud Netflix Eureka](https://spring.io/projects/spring-cloud-netflix)

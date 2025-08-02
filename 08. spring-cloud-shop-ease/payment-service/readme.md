
# 💳 Payment Microservice - Spring Boot

This is a **Spring Boot microservice** responsible for managing **payment transactions**. It is part of a distributed microservices architecture and integrates with **Eureka Discovery Server** and **Spring Cloud Config Server**.

---

## 🚀 Overview

- **Framework**: Spring Boot
- **Discovery**: Eureka Client
- **Configuration**: Spring Cloud Config Server
- **Communication**: Feign Clients
- **Port**: 8082

---

## 🧩 Key Components

### 🔸 `PaymentServiceApplication.java`

```java
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
```

- Registers with **Eureka** for service discovery.
- Enables **Feign Clients** to communicate with other microservices.

---

### 🔸 `PaymentCtl.java`

```java
@RestController
@RequestMapping("ctl/payment")
public class PaymentCtl {

    @Value(value = "100")
    private double balance;

    @PostMapping("makePayment")
    public double makePayment(@RequestParam("amt") double amt) {
        balance = balance - amt;
        return balance;
    }

    @GetMapping("check")
    public double checkBalance() {
        return balance;
    }
}
```

- **POST /ctl/payment/makePayment?amt=50**  
  Deducts the amount from the balance.

- **GET /ctl/payment/check**  
  Returns the current balance.

---

### 🔸 `application.yml`

```yaml
server:
  port: 8082

spring:
  application:
    name: payment-service
  config:
    import: configserver:http://localhost:8888
```

- Runs the service on **port 8082**.
- Fetches centralized configuration from the **Config Server**.

---

## 🧑‍💻 For Beginners

### 🔬 Test Endpoints Using cURL or Postman

1. **Check Balance**
   ```
   curl http://localhost:8082/ctl/payment/check
   ```

2. **Make a Payment**
   ```
   curl -X POST http://localhost:8082/ctl/payment/makePayment?amt=20
   ```

---

## 🧠 For Advanced Users

- Add database integration with JPA to persist transactions.
- Secure endpoints using Spring Security or JWT.
- Use **Feign** to call **Order** or **Inventory** services.
- Implement **retry**, **circuit breaker**, and **fallback** with Resilience4j.
- Monitor service using Spring Boot Actuator and Prometheus.

---

## 📘 References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)
- [Spring Cloud Netflix Eureka](https://spring.io/projects/spring-cloud-netflix)

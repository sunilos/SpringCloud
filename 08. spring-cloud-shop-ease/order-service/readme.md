
# 🧾 Order Microservice - Spring Boot

This project implements the **Order Service** in a Spring Cloud microservices architecture. It coordinates with **Inventory Service**, **Payment Service**, and **Kafka** for asynchronous processing.

---

## 🚀 Overview

- **Framework**: Spring Boot
- **Service Discovery**: Eureka
- **Config Management**: Spring Cloud Config Server
- **Inter-Service Communication**: OpenFeign
- **Message Queue**: Apache Kafka

---

## 🧩 Key Components

### 🔸 `OrderServiceApplication.java`

```java
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
```

- Bootstraps the service.
- Registers with Eureka.
- Enables Feign for service-to-service communication.

---

### 🔸 `OrderCtl.java`

```java
@RestController
@RequestMapping(value = {"OrderCtl", "ctl/order"})
public class OrderCtl {

    @Autowired
    public PaymentServiceFeignClient paymentService;

    @Autowired
    public InventoryServiceFeignClient inventoryService;

    @Autowired
    KafkaProducer producer;

    @PostMapping("place")
    public String placeOrder(@RequestBody OrderDetails orderDetails) {
        inventoryService.sell(orderDetails.getItems());
        paymentService.makePayment(orderDetails.getItems() * 10);
        producer.sendDetails(orderDetails);
        return "Order placed successfully!";
    }

    @GetMapping
    public String get() {
        return this.getClass().getName() + ": Running...";
    }
}
```

- **POST /ctl/order/place**: Places an order, deducts stock, makes payment, and publishes to Kafka.

---

### 🔸 `OrderDetails.java`

POJO containing:
```java
private int items;
private String email;
```

---

### 🔸 Feign Clients

#### `InventoryServiceFeignClient.java`
```java
@FeignClient(name = "inventory-service")
public interface InventoryServiceFeignClient {
    @PostMapping("/ctl/inventory/update")
    public int sell(@RequestParam("qty") int qty);
}
```

#### `PaymentServiceFeignClient.java`
```java
@FeignClient(name = "payment-service")
public interface PaymentServiceFeignClient {
    @PostMapping("/ctl/payment/makePayment")
    public double makePayment(@RequestParam("amt") double amt);
}
```

---

### 🔸 KafkaProducer.java

```java
@Service
public class KafkaProducer {
    @Autowired
    KafkaTemplate<String, Object> template;

    public void sendDetails(OrderDetails orderDetails) {
        template.send("order-topic", orderDetails);
    }
}
```

---

### 🔸 `application.yml`

```yaml
server:
  port: 8083

spring:
  application:
    name: order-service
  config:
    import: configserver:http://localhost:8888
  kafka:
    producer:
      bootstrap-servers: localhost:8084
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
      properties:
        spring.json.trusted.packages: com.order.details
```

- Exposes the service on **port 8083**.
- Communicates with Kafka running on port **8084**.

---

## 🧪 Test the API

```bash
curl -X POST http://localhost:8083/ctl/order/place \
     -H "Content-Type: application/json" \
     -d '{"items": 5, "email": "user@example.com"}'
```

---

## 🧠 For Advanced Users

- Integrate with database using JPA/Hibernate.
- Add validation and exception handling.
- Apply Circuit Breakers and Retries via Resilience4j.
- Monitor and trace requests with Spring Boot Actuator and Sleuth.
- Secure endpoints with OAuth2 or JWT.

---

## 📘 References

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Cloud Netflix](https://spring.io/projects/spring-cloud-netflix)
- [Apache Kafka](https://kafka.apache.org/)

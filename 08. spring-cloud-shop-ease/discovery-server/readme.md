
# 🌐 Spring Cloud Discovery Server (Eureka)

This project contains the **DiscoveryServerApplication**, which acts as a **service registry** using **Netflix Eureka Server**, part of the Spring Cloud ecosystem. It enables dynamic service discovery for microservice-based applications.

---

## 🧩 What Is a Discovery Server?

A Discovery Server is a central registry where microservices **register themselves** and **discover** other services. This eliminates the need for hardcoding IP addresses or hostnames.

Spring Cloud uses **Netflix Eureka** to implement this functionality.

---

## 🚀 Features

- Acts as a **service registry**.
- Enables **dynamic discovery** of microservices.
- Built with **Spring Boot** and **Spring Cloud Netflix Eureka**.
- Lightweight and easy to configure.
- Supports **HA setups** with peer awareness.

---

## 📂 Project Structure

### `DiscoveryServerApplication.java`

```java
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
```

- **@EnableEurekaServer**: Enables Eureka service registry.
- **@SpringBootApplication**: Marks the entry point of the Spring Boot app.

---

### `application.yml`

```yaml
server:
  port: 8761

spring:
  application:
    name: discovery-server

eureka:
  server:
    peer-node-read-timeout-ms: 5000
  client:
    registerWithEureka: false
    fetchRegistry: false
```

- **Port 8761**: Default Eureka dashboard port.
- **registerWithEureka: false**: Since this is the server, it does not register itself.
- **fetchRegistry: false**: The server doesn't need to fetch other registries.

---

## 🧑‍💻 For Beginners

1. Clone the repository:
   ```bash
   git clone https://github.com/your-org/discovery-server.git
   cd discovery-server
   ```

2. Ensure you have:
   - Java 11+
   - Maven or Gradle
   - Spring Cloud dependencies

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Open browser and visit:
   ```
   http://localhost:8761
   ```

---

## 🧠 For Advanced Users

- **Peer Aware Clustering**:
  Add multiple Eureka servers and use `eureka.client.service-url.defaultZone` in config.

- **Security Integration**:
  Use Spring Security to protect the Eureka dashboard.

- **Actuator + Health Checks**:
  Use `/actuator/health` to integrate with monitoring tools.

---

## 📘 References

- [Spring Cloud Eureka Docs](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
- [Netflix Eureka GitHub](https://github.com/Netflix/eureka)

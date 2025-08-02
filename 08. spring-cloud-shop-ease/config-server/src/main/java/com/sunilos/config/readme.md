
# 🛠️ Spring Cloud Config Server

This project contains the **ConfigServerApplication**, which serves as a centralized **configuration server** for microservices using **Spring Cloud Config Server**. It enables distributed applications to retrieve externalized configuration from a central repository, typically a Git repository.

---

## 📦 Project Overview

- **Framework**: Spring Boot
- **Spring Cloud Modules Used**:
  - `@EnableConfigServer`: Activates the Spring Cloud Config Server.
  - `@EnableDiscoveryClient`: Registers this service with a discovery server (e.g., Eureka).

---

## 📂 Package Structure

```java
package com.sunilos.config;
```

### 🔧 Class: `ConfigServerApplication.java`

```java
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```

### ✅ Functionality

- **@EnableConfigServer**: Converts this Spring Boot application into a configuration server.
- **@EnableDiscoveryClient**: Registers this config server with a service registry (like Eureka).
- **SpringApplication.run()**: Bootstraps the application.

---

## 📌 Prerequisites

- Java 11 or higher
- Maven or Gradle
- Spring Cloud dependencies
- A Git-based config repository (local or remote)

---

## 🚀 How to Run

1. **Clone the project**:
   ```bash
   git clone https://github.com/your-org/config-server.git
   cd config-server
   ```

2. **Configure application.properties or application.yml**:
   ```properties
   server.port=8888
   spring.cloud.config.server.git.uri=https://github.com/your-org/config-repo
   spring.application.name=config-server
   eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

---

## 🔍 Verify It’s Working

Access your configuration via:
```
http://localhost:8888/{application}/{profile}
# Example:
http://localhost:8888/payment-service/dev
```

---

## 🧑‍💻 Author

- **SunilOS**
- Version: 1.0

---

## 📘 Reference

- [Spring Cloud Config Docs](https://cloud.spring.io/spring-cloud-config/)
- [Spring Cloud Netflix Eureka](https://cloud.spring.io/spring-cloud-netflix/)

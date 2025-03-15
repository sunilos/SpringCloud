# **Eureka Client Configuration (YAML)**
This YAML configuration is used for a **Spring Boot microservice** to register itself with a **Eureka Server**.

## **Configuration Breakdown**

```yml
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
    registerWithEureka: true
    fetchRegistry: true
  instance:
    preferIpAddress: false
```

## 1️⃣ Eureka Client Settings

### ➤ `serviceUrl.defaultZone`
Defines the URL of the **Eureka Server** where this microservice will register.  
The default URL **`http://localhost:8761/eureka/`** indicates that the Eureka Server is running locally on **port 8761**.

### ➤ `registerWithEureka`
- **`true`** → The service will **register itself** with the Eureka server.
- **`false`** → The service will **not register** itself.

### ➤ `fetchRegistry`
- **`true`** → The client will **fetch a list** of registered services from Eureka.
- **`false`** → The client will **not fetch** the registry and will only rely on its local configuration.

---

## 2️⃣ Eureka Instance Settings

### ➤ `preferIpAddress`
- **`true`** → The instance will **use its IP address** instead of the hostname when registering in Eureka.
- **`false`** → The instance will **use its hostname** instead.

---

This configuration is used for **service discovery** in a **Spring Cloud microservices architecture**. 🚀

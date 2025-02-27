# What Does This Application Do?

This is a **Spring Cloud Config Server** that provides externalized, centralized configuration for microservices.
Microservices can fetch their configurations from this server instead of maintaining their own configuration files.
Typically, this server retrieves configurations from a **Git repository** or a **local properties file**.
It helps in **managing environment-specific properties** efficiently (e.g., different settings for dev, staging, production).

---

# How This Server Works

When it starts, it serves configurations stored in a repository.
Microservices fetch their configuration from this server using REST endpoints.

### Example endpoint:
```bash
http://localhost:8888/application-name/profile
```
- **application-name**: The name of the service requesting configuration.
- **profile**: The environment profile (e.g., `dev`, `prod`).

---

# Use Case

Assume you have multiple microservices (`service-a`, `service-b`, etc.), and you need to store their configuration in a centralized place instead of maintaining separate `.properties` or `.yml` files.

- This **Config Server** fetches configurations from a **Git repository**.
- Microservices connect to this server to get their configuration dynamically.


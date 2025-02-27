# **Spring Cloud Config Server Configuration Explanation**

The given configuration sets up a **Spring Cloud Config Server**, which is responsible for managing external configurations for distributed systems.

---

## **Breakdown of the Configuration**

### **1. Server Port Configuration**
```yaml
server:
  port: 8888
```
- This sets the **server port** to `8888`, which is the default port for a Spring Cloud Config Server.
- Clients will request configurations from `http://localhost:8888/{application}/{profile}`.

---

### **2. Application Name**
```yaml
spring:
  application:
    name: config-server
```
- Assigns the name **"config-server"** to this application.
- This name is useful when registering the service in a service discovery tool like **Eureka**.

---

### **3. Config Server Git Configuration**
```yaml
  cloud:
    config:
      server:
        git:
          uri: https://github.com/SawanPanwar/Spring-Cloud-Config.git
          clone-on-start: true
```
- Configures **Spring Cloud Config Server** to fetch configuration files from a remote **Git repository**.
- The **Git URI** (`https://github.com/SawanPanwar/Spring-Cloud-Config.git`) specifies the repository containing configuration files.
- `clone-on-start: true` ensures that the Git repository is cloned at the time of the Config Server startup.

---

## **How It Works**

### **1. Config Server Startup**
- The Config Server starts on **port 8888**.
- It clones the Git repository (`Spring-Cloud-Config.git`).
- Reads configuration properties from the files inside the repository.

### **2. Client Application Requests Configurations**
- Client applications (e.g., microservices) fetch their configurations by calling:
  ```
  http://localhost:8888/{application}/{profile}
  ```
- Example:
  ```
  http://localhost:8888/user-service/dev
  ```
  - Fetches `user-service` configurations for the **dev** profile.

---

## **Expected Repository Structure**
The Git repository (`Spring-Cloud-Config.git`) should contain property or YAML files structured like this:

```
Spring-Cloud-Config.git/
│── application.yml  (global configs)
│── user-service.yml (configs for user-service)
│── user-service-dev.yml (configs for user-service in dev)
│── order-service.yml (configs for order-service)
│── order-service-prod.yml (configs for order-service in production)
```
- **`application.yml`** → Contains global configurations.
- **`user-service.yml`** → Configurations for `user-service`.
- **`user-service-dev.yml`** → Configurations for `user-service` in the `dev` environment.

---

## **Additional Features**

### **1. Using Branches**
- You can specify a branch from which the config server should pull data.
- Example:
  ```yaml
  spring:
    cloud:
      config:
        server:
          git:
            uri: https://github.com/SawanPanwar/Spring-Cloud-Config.git
            default-label: main  # Fetch configs from the main branch
  ```

### **2. Enable Native File System Instead of Git**
- If you don't want to use Git, you can store configs in the local file system:
  ```yaml
  spring:
    cloud:
      config:
        server:
          native:
            search-locations: file:///path/to/local/configs
  ```

---

## **Summary**
- **Spring Cloud Config Server** is a centralized configuration management system.
- It fetches configurations from **a remote Git repository**.
- Applications request configurations based on their name and profile.
- **Port 8888** is used by default for serving configurations.

Would you like an explanation on **how a client application fetches configurations from this Config Server**? 🚀


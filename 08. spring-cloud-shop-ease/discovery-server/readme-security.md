
# 🔐 Securing Eureka Dashboard with Spring Security

This guide helps you **secure the Eureka dashboard** in your Spring Boot Discovery Server using **Spring Security**.

---

## ✅ 1. Add Spring Security Dependency

### Maven
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### Gradle
```groovy
implementation 'org.springframework.boot:spring-boot-starter-security'
```

---

## ✅ 2. Configure Credentials in `application.yml` or `application.properties`

### YAML
```yaml
spring:
  security:
    user:
      name: admin
      password: admin123
```

### Properties
```properties
spring.security.user.name=admin
spring.security.user.password=admin123
```

---

## ✅ 3. Add Security Configuration Class

### Spring Boot 2.x (with `WebSecurityConfigurerAdapter`)
```java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/eureka/**").authenticated()
                .anyRequest().permitAll()
            .and()
            .httpBasic();
    }
}
```

---

## ✅ 4. Access Eureka Dashboard

Open your browser and go to:

```
http://localhost:8761
```

You will be prompted to enter your username (`admin`) and password (`admin123`).

---

## 🔐 Optional: Role-Based Authorization

```java
http
  .csrf().disable()
  .authorizeRequests()
      .antMatchers("/eureka/**").hasRole("ADMIN")
      .anyRequest().permitAll()
  .and()
  .httpBasic();
```

---

## 🛡️ Security Best Practices

- Don’t use default passwords in production.
- Prefer HTTPS for encrypted transport.
- For enterprise setups, consider OAuth2/JWT integration for SSO.
- Restrict access to internal dashboards using firewall or IP filtering.

---

## 🧠 Note

Spring Boot 3.x deprecated `WebSecurityConfigurerAdapter`. Use `SecurityFilterChain` instead for newer apps.

---

## 📘 Reference

- [Spring Security Docs](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [Securing Eureka with Spring Security](https://cloud.spring.io/spring-cloud-netflix/multi/multi__service_discovery_eureka_clients.html)

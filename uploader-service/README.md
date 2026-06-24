# Uploader Service

Provides a **reactive microservice** built with Spring Cloud, WebFlux, and Netty.  
It integrates with Eureka for service discovery, load‑balancing, and the API gateway via Spring Cloud Gateway.

The service stores events in a MongoDB database, using Spring Data MongoDB for persistence.

## Prerequisites

- Java 23
- Gradle (wrapper included)

## Running the service

```bash
cd uploader-service
./gradlew bootRun
```

The uploader listens on port **2222**.

---

[Max Alencar](https://github.com/maxalencar)

## Gateway Service

Implements **Spring Cloud Gateway** for routing requests to downstream APIs and applying cross‑cutting concerns such as security, metrics, and resiliency.

### Prerequisites

- Java 23
- Gradle (wrapper included)
- Spring Cloud version: 2022.0.4

### Running the service

```bash
cd gateway-service
./gradlew bootRun
```

The gateway listens on port **8090**.

---

[Max Alencar](https://github.com/maxalencar)

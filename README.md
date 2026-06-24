# CS Event Uploader

**Reactive microservice** built with Spring Cloud, WebFlux, and Netty.  
It includes service discovery (Eureka), load‑balancing, and an API gateway (Spring Cloud Gateway).

## Prerequisites

- Java 23
- Gradle (wrapper included)
- Docker (optional, for running the full stack)

## Building & Running Services

### Individual services

Run each service from its directory:

```bash
# Discovery Service
cd discovery-service
./gradlew bootRun

# Uploader Service
cd uploader-service
./gradlew bootRun

# Gateway Service
cd gateway-service
./gradlew bootRun
```

### Full stack with Docker Compose

Start all services, MongoDB, and the admin UI in one command:

```bash
docker compose up --build
```

The services listen on:

| Service | Port |
|---------|------|
| Eureka (Discovery) | 8761 |
| Gateway | 8090 |
| Uploader | 2222 |
| MongoDB | 27017 |
| Mongo‑Express | 8081 |

Stop the stack:

```bash
docker compose down
```

## Event File Format

```json
{"id":"scsmbstgrd","state":"FINISHED","type":"APPLICATION_LOG","host":"123456","timestamp":1491377495217}
```

(Examples of valid events are listed in the original file.)

## API Usage

Upload events:

```bash
curl -X POST -F file=@EVENTS.json http://localhost:8089/uploader/
```

Fetch all stored events:

```bash
curl http://localhost:8089/uploader/
```

## Contributing

Feel free to open issues or submit pull requests. Follow the project's coding standards and run tests before submitting changes.

---

[Max Alencar](https://github.com/maxalencar)

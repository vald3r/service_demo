# service_demo

Learning project (2022): a small Spring Boot CRUD service ("person directory") focused on packaging and deployment rather than business logic.

## Stack

- Spring Boot 2.6 — Web, Data JPA, Thymeleaf, Actuator
- Layered structure: controller → service → repository, with JUnit tests
- Externalized configuration (`src/main/resources/config`), DB scripts (`src/main/resources/db`)

## Packaging & deployment

- `Dockerfile` — container image for the service
- `docker-compose.yml` — local orchestration
- `k8s/` — Kubernetes deployment manifests

## Status

Kept as a reference learning project; not actively developed.

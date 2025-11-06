# 🏠 Property Management API

A **Spring Boot REST API** for managing properties, tenants, and leases in a property rental system.  
The project uses **Spring Boot 3**, **Spring Data JPA**, **H2/MySQL**, and **Springdoc OpenAPI** (Swagger UI) for API documentation.  

---

## 🚀 Features
- **Property Management**
  - Add properties with address and status (`AVAILABLE`, `RENTED`, `UNDER_MAINTENANCE`)
  - View all properties (with pagination)
  - Find property by ID or status
- **Tenant Management**
  - Add tenants
  - View tenants and their rental history
- **Lease Management**
  - Create leases linking tenants and properties
  - Track lease duration, rent, deposit, and status (`ACTIVE`, `EXPIRED`, `TERMINATED`)
- **API Documentation** via Swagger UI

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA + Hibernate
- Postgres
- Caffeine in-memory caching
- Lombok
- Springdoc OpenAPI (Swagger UI)
- Docker + Docker Compose (optional)

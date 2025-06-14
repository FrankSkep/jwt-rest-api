# Jwt Authentication REST API

REST API developed with **Spring Boot** for user management and authentication using **JWT (JSON Web Tokens)**.

## Features

- User registration and authentication
- Role and permission management
- JWT-based security
- Protected and public endpoints
- Interactive documentation with Swagger/OpenAPI
- Integration with PostgreSQL database
- Data validation and centralized exception handling

## Technologies

- Java 21
- Spring Boot 3.2.8
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (jjwt)
- Lombok
- Swagger/OpenAPI

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/FrankSkep/jwt-rest-api.git
   cd jwt-rest-api
   ```

2. **Set the environment variables in `src/main/resources/.env`:**
   ```
   DB_URL=jdbc:postgresql://localhost:5432/database_name
   DB_USERNAME=your_user
   DB_PASSWORD=your_password
   JWT_SECRET_KEY=your_secret_key
   ```

3. **Make sure PostgreSQL is running and the database is created.**

4. **Install dependencies and run the application:**
   ```bash
   ./mvnw clean package -DskipTests
   ./mvnw spring-boot:run
   ```

## Main Endpoints

- `POST /api/auth/register` — User registration
- `POST /api/auth/login` — Authentication and JWT retrieval
- `GET /api/users/me` — Authenticated user information
- `PUT /api/users/{id}/role` — Update role (requires permissions)
- `PUT /api/users/me/password` — Change password

## Documentation

Access the interactive documentation at:
`http://localhost:8080/swagger-ui.html`
# Jwt REST API

JwtAuthAPI is a JWT (JSON Web Tokens) based authentication API built with Spring Boot.

## Requirements

- Java 21
- Maven
- PostgreSQL (or any compatible database)

## Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/FrankSkep/jwt-rest-api
   cd jwt-rest-api
   ```

2. Create a `.env` file in `src/main/resources` with the following environment variables:

   ```ini
   DB_URL=jdbc:postgresql://localhost:5432/your_database
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   JWT_SECRET_KEY=your_secret_key
   ```

3. Build and run the application:
   ```sh
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

## API Documentation

All endpoints and their details are documented and available for interactive testing in Swagger UI:

[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)
# Jwt Auth API

JwtAuthAPI is an authentication API based on JWT (JSON Web Tokens) built with Spring Boot.

## Requirements

- Java 17 or higher
- Maven
- MySQL (or any other compatible database)

## Configuration

1. Clone the repository:
    ```sh
    git clone https://github.com/FrankSkep/jwt-auth-api
    cd jwt-auth-api
    ```

2. Create a `.env` file in `src/main/resources` with the following environment variables:
    ```ini
    DB_URL=jdbc:mysql://localhost:3306/your_database
    DB_USERNAME=your_username
    DB_PASSWORD=your_password
    JWT_SECRET_KEY=your_secret_key
    ```

3. Build and run the application:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints

### User Registration

- **URL:** `/api/auth/register`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "username": "username",
        "password": "password",
        "firstname": "firstname",
        "lastname": "lastname",
        "country": "country"
    }
    ```
- **Successful Response:**
    ```json
    {
        "token": "jwt_token"
    }
    ```

### Login

- **URL:** `/api/auth/login`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "username": "username",
        "password": "password"
    }
    ```
- **Successful Response:**
    ```json
    {
        "token": "jwt_token"
    }
    ```

### Update User

- **URL:** `/api/users`
- **Method:** `PUT`
- **Request Body:**
    ```json
    {
        "username": "new_username",
        "firstname": "new_firstname",
        "lastname": "new_lastname",
        "country": "new_country"
    }
    ```
- **Successful Response:**
    ```json
    {
        "message": "Data updated successfully."
    }
    ```

### Update User Role

- **URL:** `/api/users/{id}`
- **Roles:** `ADMIN`
- **Method:** `PATCH`
- **Request Body:**
    ```json
    {
        "role": "new_role"
    }
    ```
- **Successful Response:** `200 OK`

### Delete User

- **URL:** `/api/users/{id}`
- **Roles:** `ADMIN`
- **Method:** `DELETE`
- **Successful Response:** `204 No Content`

### Update Password

- **URL:** `/api/users/password`
- **Method:** `PATCH`
- **Request Body:**
    ```json
    {
        "oldPassword": "old_password",
        "newPassword": "new_password"
    }
    ```
- **Successful Response:**
    ```json
    {
        "message": "Password updated successfully."
    }
    ```
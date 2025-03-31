# Jwt Auth API

JwtAuthAPI is an authentication API based on JWT (JSON Web Tokens) built with Spring Boot.

## Requirements

- Java 21
- Maven
- PostgreSQL (or any other compatible database)

## Configuration

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
   mvn clean install
   mvn spring-boot:run
   ```

## Endpoints

### Authentication

| Method | Endpoint         | Description                  | Sample Valid Request Body |
| ------ | ---------------- | ---------------------------- | ------------------------- |
| POST   | /api/auth/signin | Log in and obtain JWT token. | [JSON](#signin)           |
| POST   | /api/auth/signup | Register a new user.         | [JSON](#signup)           |

### Users

| Method | Endpoint            | Description                               | Sample Valid Request Body |
| ------ | ------------------- | ----------------------------------------- | ------------------------- |
| PUT    | /api/users          | Update the authenticated user's details.  | [JSON](#userupdate)       |
| PATCH  | /api/users/{id}     | Update the role of a user (Admin only).   | [JSON](#roleupdate)       |
| DELETE | /api/users          | Delete the authenticated user's account.  |                           |
| DELETE | /api/users/{id}     | Delete a user by ID (Admin only).         |                           |
| PATCH  | /api/users/password | Update the authenticated user's password. | [JSON](#passwordupdate)   |

## Sample Valid JSON Request Bodies

##### <a id="signup">Sign Up -> /api/auth/signup</a>

```json
{
  "username": "john_doe",
  "password": "Password123",
  "firstname": "John",
  "lastname": "Doe",
  "country": "USA"
}
```

##### <a id="signin">Log In -> /api/auth/signin</a>

```json
{
  "username": "john_doe",
  "password": "Password123"
}
```

##### <a id="userupdate">Update User -> /api/users</a>

```json
{
  "username": "john_doe_updated",
  "firstname": "John",
  "lastname": "Doe",
  "country": "USA"
}
```

##### <a id="roleupdate">Update Role -> /api/users/{id}</a>

```json
"ROLE_NAME"
```

##### <a id="passwordupdate">Update Password -> /api/users/password</a>

```json
{
  "oldPassword": "OldPassword123",
  "newPassword": "NewPassword123"
}
```

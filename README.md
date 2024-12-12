# JwtAuthAPI

JwtAuthAPI es una API de autenticación basada en JWT (JSON Web Tokens) construida con Spring Boot.

## Requisitos

- Java 17 o superior
- Maven
- MySQL (o cualquier otra base de datos compatible)

## Configuración

1. Clona el repositorio:
    ```sh
    git clone https://github.com/FrankSkep/jwt-auth-api
    cd jwt-auth-api
    ```

2. Crea un archivo `.env` en `src/main/resources` con las siguientes variables de entorno:
    ```ini
    DB_URL=jdbc:mysql://localhost:3306/tu_base_de_datos
    DB_USERNAME=tu_usuario
    DB_PASSWORD=tu_contraseña
    JWT_SECRET_KEY=tu_clave_secreta
    ```

3. Compila y ejecuta la aplicación:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints

### Registro de Usuario

- **URL:** `/api/auth/register`
- **Método:** `POST`
- **Cuerpo de la Solicitud:**
    ```json
    {
        "username": "usuario",
        "password": "contraseña",
        "firstname": "nombre",
        "lastname": "apellido",
        "country": "país"
    }
    ```
- **Respuesta Exitosa:**
    ```json
    {
        "token": "jwt_token"
    }
    ```

### Inicio de Sesión

- **URL:** `/api/auth/login`
- **Método:** `POST`
- **Cuerpo de la Solicitud:**
    ```json
    {
        "username": "usuario",
        "password": "contraseña"
    }
    ```
- **Respuesta Exitosa:**
    ```json
    {
        "token": "jwt_token"
    }
    ```

### Eliminar Usuario

- **URL:** `/api/auth/delete/{username}`
- **Roles:** `ADMIN`
- **Método:** `DELETE`
- **Respuesta Exitosa:** `204 No Content`

## Seguridad

- Las contraseñas deben tener al menos 8 caracteres, incluir una letra mayúscula, un número y no contener espacios en blanco.

## Estructura del Proyecto

- `src/main/java/jwtapi`: Código fuente principal.
    - `controller`: Controladores REST.
    - `dto`: Objetos de transferencia de datos.
    - `entity`: Entidades JPA.
    - `exception`: Clases de manejo de excepciones.
    - `jwt`: Clases relacionadas con JWT.
    - `repository`: Repositorios JPA.
    - `service`: Servicios de negocio.
    - `config`: Configuración de seguridad y otros.

- `src/main/resources`: Recursos de la aplicación.
    - `application.properties`: Archivo de configuración principal.
package app.AuthAPIREST.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite CORS para todas las rutas
                        .allowedOrigins("http://localhost:5173") // Permite estos orígenes
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite estos métodos HTTP
                        .allowedHeaders("*") // Permite todos los encabezados
                        .allowCredentials(true); // Permite credenciales (cookies, autenticación HTTP, etc.)
            }
        };
    }
}

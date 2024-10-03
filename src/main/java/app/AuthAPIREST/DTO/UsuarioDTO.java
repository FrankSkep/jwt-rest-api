package app.AuthAPIREST.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    public UsuarioDTO(String nombre, String apellidos, String email, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }
}

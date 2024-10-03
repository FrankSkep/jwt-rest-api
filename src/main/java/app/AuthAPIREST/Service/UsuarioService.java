package app.AuthAPIREST.Service;

import app.AuthAPIREST.DTO.UsuarioDTO;
import app.AuthAPIREST.Entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

    Usuario findByEmail(String username);

    Usuario guardarUsuario(UsuarioDTO registroDTO);

    boolean eliminarUsuario(Integer id);
}

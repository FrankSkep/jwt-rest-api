package app.AuthAPIREST.Service;

import app.AuthAPIREST.DTO.UsuarioDTO;
import app.AuthAPIREST.Entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

    public Usuario findByEmail(String username);

    public Usuario guardarUsuario(UsuarioDTO registroDTO);

    public boolean eliminarUsuario(Integer id);
}

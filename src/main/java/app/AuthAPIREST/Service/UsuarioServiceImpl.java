package app.AuthAPIREST.Service;

import app.AuthAPIREST.DTO.UsuarioDTO;
import app.AuthAPIREST.Entities.Usuario;
import app.AuthAPIREST.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    // Inyección de dependencias a través del constructor
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario findByEmail(String username) {
        return userRepo.findByEmail(username);
    }

    @Override
    public Usuario guardarUsuario(UsuarioDTO registroDTO) {
        // Verificar si ya existe un usuario con el mismo email
        if (userRepo.findByEmail(registroDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Ya existe un usuario con el mismo correo electrónico.");
        }

        // Codificar la contraseña
        String encodedPassword = passwordEncoder.encode(registroDTO.getPassword());

        // Crear un nuevo objeto Usuario
        Usuario usuario = new Usuario(
                registroDTO.getNombre(),
                registroDTO.getApellidos(),
                registroDTO.getEmail(),
                encodedPassword
        );

        // Guardar el usuario en el repositorio
        return userRepo.save(usuario);
    }

    @Override
    public boolean eliminarUsuario(Integer id) {
        Usuario usuario = userRepo.getReferenceById(id);

        if (usuario == null) {
            return false;
        }
        userRepo.delete(usuario);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = userRepo.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña incorrectos");
        }

        return new User(usuario.getEmail(), usuario.getPassword(), Collections.emptyList());
    }
}

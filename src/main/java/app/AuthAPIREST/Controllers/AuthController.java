package app.AuthAPIREST.Controllers;

import app.AuthAPIREST.Models.JwtResponse;
import app.AuthAPIREST.Configuration.JwtTokenUtil;
import app.AuthAPIREST.Models.LoginRequest;
import app.AuthAPIREST.Models.MessageResponse;
import app.AuthAPIREST.DTO.UsuarioDTO;
import app.AuthAPIREST.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioServicio;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Maneja el registro de usuario
    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody @Valid UsuarioDTO regDTO) {
        try {
            usuarioServicio.guardarUsuario(regDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Usuario registrado exitosamente"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(e.getMessage()));
        }
    }

    // Maneja el inicio de sesión de usuario
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Autentica al usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Obtiene detalles del usuario
            UserDetails userDetails = usuarioServicio.loadUserByUsername(loginRequest.getEmail());

            // Genera el token JWT
            String token = jwtTokenUtil.generateToken(userDetails);

            // Retorna la respuesta con el token
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Usuario o contraseña incorrectos"));
        }
    }

}

package com.fran.jwt.auth.utils;

import com.fran.jwt.auth.entity.User;
import com.fran.jwt.auth.exception.UserNotFoundException;
import com.fran.jwt.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticatedUserProvider {

    private final UserRepository userRepository;

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UserNotFoundException("No hay un usuario autenticado en el contexto.");
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new UserNotFoundException("Usuario autenticado no encontrado en la base de datos."));
        }

        throw new IllegalStateException("El principal no es una instancia de UserDetails.");
    }
}
package com.fran.jwt.auth.controller;

import com.fran.jwt.auth.dto.PasswordRequest;
import com.fran.jwt.auth.dto.UserRequest;
import com.fran.jwt.auth.entity.Role;
import com.fran.jwt.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PutMapping
    public ResponseEntity<UserRequest> updateUser(@RequestBody UserRequest userReq) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userService.updateUser(userDetails.getUsername(), userReq);
        return ResponseEntity.ok(userReq);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateRole(@PathVariable Long id, @RequestBody Role role) {
        userService.updateRole(id, role);
        return ResponseEntity.ok("The " + role.name() + "role is assigned to the user with id " + id);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMyUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userService.deleteUser(userDetails.getUsername());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordRequest password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userService.updatePassword(userDetails.getUsername(), password);
        return ResponseEntity.ok("Password updated successfully.");
    }
}

package com.fran.jwt.auth.controller;

import com.fran.jwt.auth.dto.PasswordRequest;
import com.fran.jwt.auth.dto.UserRequest;
import com.fran.jwt.auth.entity.Role;
import com.fran.jwt.auth.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Operations related to user management")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Update user", description = "Updates a user's data by their username")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{username}")
    public void updateUser(
            @Parameter(description = "User's username") @PathVariable String username,
            @RequestBody UserRequest user) {
        userService.updateUser(username, user);
    }

    @Operation(summary = "Update role", description = "Updates a user's role by their ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Role updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{id}/role")
    public void updateRole(
            @Parameter(description = "User's ID") @PathVariable Long id,
            @RequestBody Role role) {
        userService.updateRole(id, role);
    }

    @Operation(summary = "Delete user by ID", description = "Deletes a user by their ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}")
    public void deleteUserById(@Parameter(description = "User's ID") @PathVariable Long id) {
        userService.deleteUser(id);
    }

    @Operation(summary = "Delete user by username", description = "Deletes a user by their username")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/by-username/{username}")
    public void deleteUserByUsername(@Parameter(description = "User's username") @PathVariable String username) {
        userService.deleteUser(username);
    }

    @Operation(summary = "Update password", description = "Updates a user's password")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Password updated successfully"),
            @ApiResponse(responseCode = "400", description = "Incorrect old password"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{username}/password")
    public void updatePassword(
            @Parameter(description = "User's username") @PathVariable String username,
            @RequestBody PasswordRequest password) {
        userService.updatePassword(username, password);
    }
}
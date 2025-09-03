package com.fran.jwt.auth.dto;

import com.fran.jwt.auth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String lastname;
    private String firstname;
    private String country;
    private Role role;
}

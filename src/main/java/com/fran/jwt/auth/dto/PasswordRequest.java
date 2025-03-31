package com.fran.jwt.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PasswordRequest {
    private String oldPassword;
    private String newPassword;
}

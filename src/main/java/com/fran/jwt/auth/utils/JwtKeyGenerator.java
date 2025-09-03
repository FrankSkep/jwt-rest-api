package com.fran.jwt.auth.utils;

import io.jsonwebtoken.security.Keys;

import java.util.Base64;

public class JwtKeyGenerator {
    public static void main(String[] args) {
        // Generate a secure random key for HMAC SHA-256
        byte[] keyBytes = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);

        System.out.println("Secure Key Generated: " + base64Key);
    }
}
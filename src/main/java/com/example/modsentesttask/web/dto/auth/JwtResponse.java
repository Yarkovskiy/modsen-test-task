package com.example.modsentesttask.web.dto.auth;

public record JwtResponse(

        Long id,
        String username,
        String accessToken,
        String refreshToken
) {
}

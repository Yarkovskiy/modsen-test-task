package com.example.modsentesttask.web.dto.auth;

import jakarta.validation.constraints.NotNull;

public record JwtRequest(

        @NotNull(message = "{email.notnull}")
        String username,

        @NotNull(message = "{password.notnull}")
        String password
) {
}

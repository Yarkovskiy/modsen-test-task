package com.example.modsentesttask.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    @NotNull(message = "{email.notnull}")
    String username;

    @NotNull(message = "{password.notnull}")
    String password;
}

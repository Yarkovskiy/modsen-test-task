package com.example.modsentesttask.web.dto.auth;

import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Schema(description = "Jwt request")
public class JwtRequest {

    @Schema(description = "User's email", example = "user@example.com")
    @NotNull(message = "{email.notnull}", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 6, max = 254, message = "{email.length}", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "{email.invalid}", groups = {OnCreate.class, OnUpdate.class})
    String username;

    @Schema(description = "User's password", example = "user")
    @NotNull(message = "{password.notnull}", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 4, max = 32, message = "{password.length}", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "^[A-Za-z\\d]+$", message = "{password.invalid}", groups = {OnCreate.class, OnUpdate.class})
    String password;
}

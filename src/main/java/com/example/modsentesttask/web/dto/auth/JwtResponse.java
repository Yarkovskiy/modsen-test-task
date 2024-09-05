package com.example.modsentesttask.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    @Schema(description = "User's ID", example = "1")
    Long id;
    @Schema(description = "User's email", example = "mymail@example.com")
    String username;
    @Schema(description = "Access token", example = "eyJhbGciOiJIUz...")
    String accessToken;
    @Schema(description = "Refresh token", example = "JzdWIiOiJpdmFz...")
    String refreshToken;

}

package com.example.modsentesttask.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserResponseDto(

        @Schema(description = "User's ID", example = "1")
        Long id,
        @Schema(description = "User's email", example = "mymail@example.com")
        String username
) {
}

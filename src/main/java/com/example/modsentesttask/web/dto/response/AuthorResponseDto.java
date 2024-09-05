package com.example.modsentesttask.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record AuthorResponseDto(

        @Schema(description = "Author's ID", example = "1")
        Long id,
        @Schema(description = "Author's name", example = "John Doe")
        String name
) {
}

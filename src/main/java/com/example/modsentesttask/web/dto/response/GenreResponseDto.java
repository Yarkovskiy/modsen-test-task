package com.example.modsentesttask.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record GenreResponseDto(

        @Schema(description = "Genre ID", example = "1")
        Long id,
        @Schema(description = "Genre name", example = "third genre")
        String name
) {
}

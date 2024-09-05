package com.example.modsentesttask.web.dto.response;

import com.example.modsentesttask.domain.book.Author;
import com.example.modsentesttask.domain.book.Genre;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record BookResponseDto(

        @Schema(description = "Book ID", example = "1")
        Long id,
        @Schema(description = "Book ISBN", example = "1-234-51234-5")
        String isbn,
        @Schema(description = "Book title", example = "Title of the book")
        String title,
        @Schema(description = "Book description", example = "Description of the book")
        String description,
        @Schema(description = "Book genres")
        List<Genre> genres,
        @Schema(description = "Book authors")
        List<Author> authors
) {
}

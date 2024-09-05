package com.example.modsentesttask.web.dto.response;

import com.example.modsentesttask.domain.book.Book;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record BookLoanResponseDto(

        @Schema(description = "Book loan ID", example = "1")
        Long id,
        @Schema(description = "Loaned book")
        Book book,
        @Schema(description = "User who loaned the book.")
        UserResponseDto user,
        @Schema(description = "Borrowed time", example = "2024-09-01 15:00")
        LocalDateTime borrowedTime,
        @Schema(description = "Return time", example = "2024-10-01 15:00")
        LocalDateTime returnTime
) {
}

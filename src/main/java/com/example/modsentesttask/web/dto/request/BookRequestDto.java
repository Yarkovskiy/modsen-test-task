package com.example.modsentesttask.web.dto.request;

import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Schema(description = "Book request dto")
public record BookRequestDto(

        @Schema(description = "Book ISBN", example = "1-234-51234-5")
        @NotNull(message = "{isbn.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(min = 13, max = 13, message = "{isbn.length}", groups = {OnCreate.class, OnUpdate.class})
        @Pattern(regexp = "^(\\d-\\d{3}-\\d{5}-\\d)$",
                message = "{isbn.invalid}", groups = {OnCreate.class, OnUpdate.class})
        String isbn,

        @Schema(description = "Book title", example = "New book")
        @NotNull(message = "{title.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(min = 1, max = 255, message = "", groups = {OnCreate.class, OnUpdate.class})
        String title,

        @Schema(description = "Book description", example = "Description of new book")
        @Length(max = 1000, message = "{description.length}", groups = {OnCreate.class, OnUpdate.class})
        String description,

        @Schema(description = "List of genre IDs", example = "[1, 2]")
        @NotNull(message = "{genreIds.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @NotEmpty(message = "{genreIds.notempty}", groups = {OnCreate.class, OnUpdate.class})
        @Size(min = 1, message = "{genreIds.size}", groups = {OnCreate.class, OnUpdate.class})
        List<@Positive(message = "{genreIds.positive}", groups = {OnCreate.class, OnUpdate.class}) Long> genreIds,

        @Schema(description = "List of author IDs", example = "[1, 2]")
        @NotNull(message = "{authorIds.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @NotEmpty(message = "{authorIds.notempty}", groups = {OnCreate.class, OnUpdate.class})
        @Size(min = 1, message = "{authorIds.size}", groups = {OnCreate.class, OnUpdate.class})
        List<@Positive(message = "{authorIds.positive}", groups = {OnCreate.class, OnUpdate.class}) Long> authorIds
) {
}

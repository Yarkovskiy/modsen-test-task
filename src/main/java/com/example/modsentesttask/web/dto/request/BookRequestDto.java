package com.example.modsentesttask.web.dto.request;

import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record BookRequestDto(

        @NotNull(message = "{isbn.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(min = 10, max = 13, message = "{isbn.length}", groups = {OnCreate.class, OnUpdate.class})
        @Pattern(regexp = "^(\\d{10}|\\d{13})$",
                message = "{isbn.invalid}", groups = {OnCreate.class, OnUpdate.class})
        String isbn,

        @NotNull(message = "{title.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(min = 1, max = 255, message = "", groups = {OnCreate.class, OnUpdate.class})
        String title,

        @Length(max = 1000, message = "{description.length}", groups = {OnCreate.class, OnUpdate.class})
        String description,

        @NotNull(message = "{genreIds.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @NotEmpty(message = "{genreIds.notempty}", groups = {OnCreate.class, OnUpdate.class})
        @Size(min = 1, message = "{genreIds.size}", groups = {OnCreate.class, OnUpdate.class})
        List<Long> genreIds,

        @NotNull(message = "{authorIds.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @NotEmpty(message = "{authorIds.notempty}", groups = {OnCreate.class, OnUpdate.class})
        @Size(min = 1, message = "{authorIds.size}", groups = {OnCreate.class, OnUpdate.class})
        List<Long> authorIds
) {
}

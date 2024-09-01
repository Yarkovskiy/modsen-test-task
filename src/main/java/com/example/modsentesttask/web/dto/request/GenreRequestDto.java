package com.example.modsentesttask.web.dto.request;

import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record GenreRequestDto(

        @NotNull(message = "{genre.name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(min = 3, max = 50, message = "{genre.name.length}", groups = {OnCreate.class, OnUpdate.class})
        @Pattern(regexp = "^[a-z]+(?: [a-z]+)*$",
                message = "{genre.name.invalid}", groups = {OnCreate.class, OnUpdate.class})
        String name
) {
}

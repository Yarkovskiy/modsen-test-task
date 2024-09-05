package com.example.modsentesttask.web.dto.request;

import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Schema(description = "Author request dto")
public record AuthorRequestDto(

        @Schema(description = "Author's name", example = "John Doe")
        @NotNull(message = "{author.name.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(min = 2, max = 255, message = "{author.name.length}", groups = {OnCreate.class, OnUpdate.class})
        @Pattern(regexp = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$",
                message = "{author.name.invalid}", groups = {OnCreate.class, OnUpdate.class})
        String name
) {
}

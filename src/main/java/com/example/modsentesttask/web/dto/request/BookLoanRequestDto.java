package com.example.modsentesttask.web.dto.request;

import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Schema(description = "Book loan request dto")
public record BookLoanRequestDto(

        @Schema(description = "Book ID", example = "1")
        @NotNull(message = "{bookLoan.bookId.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Min(value = 1, message = "{bookLoan.bookId.min}", groups = {OnCreate.class, OnUpdate.class})
        Long bookId,

        @Schema(description = "User ID", example = "2")
        @NotNull(message = "{bookLoan.userId.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Min(value = 1, message = "{bookLoan.userId.min}", groups = {OnCreate.class, OnUpdate.class})
        Long userId,

        @Schema(description = "Borrowed time", example = "2024-09-01 15:00", type = "string", pattern = "yyyy-MM-dd HH:mm")
        @NotNull(message = "{borrowedTime.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @PastOrPresent(message = "{borrowedTime.pastorpresent}", groups = {OnCreate.class, OnUpdate.class})
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$", message = "{date.format.invalid}")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime borrowedTime,

        @Schema(description = "Return time", example = "2024-10-01 15:00", type = "string", pattern = "yyyy-MM-dd HH:mm")
        @NotNull(message = "{returnTime.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @FutureOrPresent(message = "{returnTime.futureorpresent}", groups = {OnCreate.class, OnUpdate.class})
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$", message = "{date.format.invalid}")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime returnTime
) {
}

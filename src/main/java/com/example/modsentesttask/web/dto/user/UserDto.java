package com.example.modsentesttask.web.dto.user;

public record UserDto(

        Long id,
        String username,
        String password,
        String passwordConfirmation
) {
}

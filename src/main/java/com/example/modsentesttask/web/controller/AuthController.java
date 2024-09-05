package com.example.modsentesttask.web.controller;

import com.example.modsentesttask.domain.user.User;
import com.example.modsentesttask.service.AuthService;
import com.example.modsentesttask.service.UserService;
import com.example.modsentesttask.web.dto.auth.JwtRequest;
import com.example.modsentesttask.web.dto.auth.JwtResponse;
import com.example.modsentesttask.web.dto.request.UserRequestDto;
import com.example.modsentesttask.web.dto.response.UserResponseDto;
import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "1. Auth Controller",
        description = "Operations related to authentication"
)
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public JwtResponse login(
            @Validated(OnCreate.class)
                @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @Operation(summary = "Register user")
    @PostMapping("/register")
    public UserResponseDto register(
            @Validated(OnCreate.class)
                @RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        User createdUser = userService.create(user);
        return userMapper.toResponseDto(createdUser);
    }

    @Operation(summary = "Refresh tokens")
    @PostMapping("/refresh")
    public JwtResponse refresh(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Refresh token request",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(example = "{ \"refreshToken\": \"eyJhbGciOiJIUzUxMiJ9...\" }"))
            )
            @Parameter(description = "refresh token")
                @RequestBody Map<String,String> request
    ) {
        String refreshToken = request.get("refreshToken");
        return authService.refresh(refreshToken);
    }

}

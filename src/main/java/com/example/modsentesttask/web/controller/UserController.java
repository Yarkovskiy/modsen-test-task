package com.example.modsentesttask.web.controller;

import com.example.modsentesttask.domain.user.User;
import com.example.modsentesttask.service.UserService;
import com.example.modsentesttask.web.dto.request.UserRequestDto;
import com.example.modsentesttask.web.dto.response.UserResponseDto;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import com.example.modsentesttask.web.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "6. User Controller",
        description = "Operations related to users"
)
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Get all users")
    @PreAuthorize("@customSecurityExpression.hasRoleAdmin()")
    @GetMapping
    public List<UserResponseDto> getAll() {
        List<User> users = userService.getAll();
        return userMapper.toResponseDto(users);
    }

    @Operation(summary = "Get user by ID")
    @PreAuthorize("@customSecurityExpression.hasRoleAdmin()")
    @GetMapping("/{id}")
    public UserResponseDto getById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        User user = userService.getById(id);
        return userMapper.toResponseDto(user);
    }

    @Operation(summary = "Update user by ID")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    @PutMapping("/{id}")
    public UserResponseDto update(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id,
            @Validated(OnUpdate.class)
                @RequestBody UserRequestDto userRequestDto
    ) {
        User user = userMapper.toEntity(userRequestDto);
        user.setId(id);

        User updatedUser = userService.update(user);
        return userMapper.toResponseDto(updatedUser);
    }

    @Operation(summary = "Delete user by ID")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        userService.delete(id);
    }

}

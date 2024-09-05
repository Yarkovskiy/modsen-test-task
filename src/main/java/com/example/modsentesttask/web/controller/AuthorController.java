package com.example.modsentesttask.web.controller;

import com.example.modsentesttask.domain.book.Author;
import com.example.modsentesttask.service.AuthorService;
import com.example.modsentesttask.web.dto.request.AuthorRequestDto;
import com.example.modsentesttask.web.dto.response.AuthorResponseDto;
import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import com.example.modsentesttask.web.mapper.AuthorMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "3. Author Controller",
        description = "Operations related to authors"
)
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @Operation(summary = "Get all authors")
    @GetMapping
    public List<AuthorResponseDto> getAllAuthors() {
        List<Author> authors = authorService.getAll();
        return authorMapper.toResponseDto(authors);
    }

    @Operation(summary = "Get author by ID")
    @GetMapping("/{id}")
    public AuthorResponseDto getAuthorById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        Author author = authorService.getById(id);
        return authorMapper.toResponseDto(author);
    }

    @Operation(summary = "Get authors by name")
    @GetMapping("/search")
    public List<AuthorResponseDto> getAuthorsByName(
            @Parameter(description = "Author's name", example = "First Author")
                @Pattern(regexp = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$",
                    message = "{author.name.invalid}", groups = {OnCreate.class, OnUpdate.class})
                @RequestParam String name
    ) {
        List<Author> authors = authorService.getByName(name);
        return authorMapper.toResponseDto(authors);
    }

    @Operation(summary = "Create new author")
    @PostMapping
    public AuthorResponseDto createAuthor(
            @Validated(OnCreate.class)
                @RequestBody AuthorRequestDto authorRequestDto
    ) {
        Author author = authorMapper.toEntity(authorRequestDto);

        Author createdAuthor = authorService.create(author);
        return authorMapper.toResponseDto(createdAuthor);
    }

    @Operation(summary = "Update author by ID")
    @PutMapping("/{id}")
    public AuthorResponseDto updateAuthorById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id,
            @Validated(OnUpdate.class)
                @RequestBody AuthorRequestDto authorRequestDto
    ) {
        Author author = authorMapper.toEntity(authorRequestDto);
        author.setId(id);

        Author updatedAuthor = authorService.update(author);
        return authorMapper.toResponseDto(updatedAuthor);
    }

    @Operation(summary = "Delete author by ID")
    @DeleteMapping("/{id}")
    public void deleteAuthorById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        authorService.delete(id);
    }

}

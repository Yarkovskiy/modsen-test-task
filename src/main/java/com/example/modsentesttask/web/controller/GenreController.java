package com.example.modsentesttask.web.controller;

import com.example.modsentesttask.domain.book.Genre;
import com.example.modsentesttask.service.GenreService;
import com.example.modsentesttask.web.dto.request.GenreRequestDto;
import com.example.modsentesttask.web.dto.response.GenreResponseDto;
import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import com.example.modsentesttask.web.mapper.GenreMapper;
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
@RequestMapping("/api/v1/genres")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "4. Genre Controller",
        description = "Operations related to genres"
)
public class GenreController {

    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @Operation(summary = "Get all genres")
    @GetMapping
    public List<GenreResponseDto> getAllGenres() {
        List<Genre> genres = genreService.getAll();
        return genreMapper.toResponseDto(genres);
    }

    @Operation(summary = "Get genre by ID")
    @GetMapping("/{id}")
    public GenreResponseDto getGenreById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        Genre genre = genreService.getById(id);
        return genreMapper.toResponseDto(genre);
    }

    @Operation(summary = "Get genre by name")
    @GetMapping("/search")
    public GenreResponseDto getGenreByName(
            @Parameter(description = "Genre name", example = "first genre")
            @Pattern(regexp = "^[a-z]+(?: [a-z]+)*$",
                    message = "{genre.name.invalid}", groups = {OnCreate.class, OnUpdate.class})
            @RequestParam String name
    ) {
        Genre genre = genreService.getByName(name);
        return genreMapper.toResponseDto(genre);
    }

    @Operation(summary = "Create new genre")
    @PostMapping
    public GenreResponseDto createGenre(
            @Validated(OnCreate.class)
                @RequestBody GenreRequestDto genreRequestDto
    ) {
        Genre genre = genreMapper.toEntity(genreRequestDto);

        Genre createdGenre = genreService.create(genre);
        return genreMapper.toResponseDto(createdGenre);
    }

    @Operation(summary = "Update genre by ID")
    @PutMapping("/{id}")
    public GenreResponseDto updateGenreById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id,
            @Validated(OnUpdate.class)
                @RequestBody GenreRequestDto genreRequestDto
    ) {
        Genre genre = genreMapper.toEntity(genreRequestDto);
        genre.setId(id);

        Genre updatedGenre = genreService.update(genre);
        return genreMapper.toResponseDto(updatedGenre);
    }

    @Operation(summary = "Delete genre by ID")
    @DeleteMapping("/{id}")
    public void deleteGenreById (
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        genreService.delete(id);
    }

}

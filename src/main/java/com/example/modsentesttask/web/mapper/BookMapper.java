package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.book.Author;
import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.domain.book.Genre;
import com.example.modsentesttask.service.AuthorService;
import com.example.modsentesttask.service.GenreService;
import com.example.modsentesttask.web.dto.request.BookRequestDto;
import com.example.modsentesttask.web.dto.response.BookResponseDto;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper
        extends Mappable<Book, BookRequestDto, BookResponseDto> {

    @Mapping(source = "genreIds", target = "genres", qualifiedByName = "mapGenreIdsToGenres")
    @Mapping(source = "authorIds", target = "authors", qualifiedByName = "mapAuthorIdsToAuthors")
    Book toEntity(
            BookRequestDto dto,
            @Context GenreService genreService,
            @Context AuthorService authorService
    );

    @Named("mapGenreIdsToGenres")
    default List<Genre> mapGenreIdsToGenres(
            List<Long> genreIds,
            @Context GenreService genreService
    ) {
        return genreIds.stream()
                .map(genreService::getById)
                .collect(Collectors.toList());
    }

    @Named("mapAuthorIdsToAuthors")
    default List<Author> mapAuthorIdsToAuthors(
            List<Long> authorIds,
            @Context AuthorService authorService
    ) {
        return authorIds.stream()
                .map(authorService::getById)
                .collect(Collectors.toList());
    }

}



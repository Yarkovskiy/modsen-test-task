package com.example.modsentesttask.web.dto.book;

import com.example.modsentesttask.domain.book.Author;
import com.example.modsentesttask.domain.book.Genre;

import java.util.List;

public record BookDto(

        Long id,
        String isbn,
        String title,
        String description,
        List<Genre> genres,
        List<Author> authors
) {
}

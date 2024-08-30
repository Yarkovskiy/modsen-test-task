package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.book.Genre;

public interface GenreService {

    Genre getById(Long id);

    Genre getByName(String name);

    Genre update(Genre genre);

    Genre create(Genre genre);

    void delete(Long id);

}

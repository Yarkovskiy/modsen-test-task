package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.book.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAll();

    List<Genre> getAllByIdIn(List<Long> ids);

    Genre getById(Long id);

    Genre getByName(String name);

    Genre update(Genre genre);

    Genre create(Genre genre);

    void delete(Long id);

}

package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.book.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAll();

    List<Author> getAllByIdIn(List<Long> ids);

    Author getById(Long id);

    List<Author> getByName(String name);

    Author update(Author author);

    Author create(Author author);

    void delete(Long id);

}

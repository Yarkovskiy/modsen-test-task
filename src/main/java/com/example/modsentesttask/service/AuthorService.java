package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.book.Author;

public interface AuthorService {

    Author getById(Long id);

    Author getByName(String name);

    Author update(Author author);

    Author create(Author author);

    void delete(Long id);

}

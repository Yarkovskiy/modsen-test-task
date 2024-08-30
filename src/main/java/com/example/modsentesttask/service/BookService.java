package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.book.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getById(Long id);

    Book getByIsbn(String isbn);

    Book create(Book book);

    Book update(Book book);

    void delete(Book book);
}

package com.example.modsentesttask.service.impl;

import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book getByIsbn(String isbn) {
        return null;
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

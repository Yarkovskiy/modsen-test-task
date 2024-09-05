package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.book.BookLoan;

import java.util.List;

public interface BookLoanService {

    List<BookLoan> getAll();

    BookLoan getById(Long id);

    List<BookLoan> getAllByUserId(Long userId);

    BookLoan getByBookId(Long bookId);

    BookLoan create(BookLoan bookLoan);

    void delete(Long id);

}

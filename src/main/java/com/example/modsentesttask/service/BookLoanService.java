package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.book.BookLoan;

import java.util.List;

public interface BookLoanService {

    List<BookLoan> getAllByUserId(int userId);

    boolean isBookAlreadyLoaned(Long bookId);

    BookLoan create(BookLoan bookLoan);

    BookLoan update(BookLoan bookLoan);

    void delete(Long id);

}

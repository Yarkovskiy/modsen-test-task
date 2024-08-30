package com.example.modsentesttask.service.impl;

import com.example.modsentesttask.domain.book.BookLoan;
import com.example.modsentesttask.service.BookLoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanServiceImpl implements BookLoanService {

    @Override
    public List<BookLoan> getAllByUserId(int userId) {
        return List.of();
    }

    @Override
    public boolean isBookAlreadyLoaned(Long bookId) {
        return false;
    }

    @Override
    public BookLoan create(BookLoan bookLoan) {
        return null;
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

package com.example.modsentesttask.service.impl;

import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.domain.book.BookLoan;
import com.example.modsentesttask.domain.exception.ResourceNotFoundException;
import com.example.modsentesttask.domain.user.User;
import com.example.modsentesttask.repository.BookLoanRepository;
import com.example.modsentesttask.service.BookLoanService;
import com.example.modsentesttask.service.BookService;
import com.example.modsentesttask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {

    private final BookLoanRepository bookLoanRepository;

    private final BookService bookService;
    private final UserService userService;

    @Override
    public List<BookLoan> getAll() {
        return bookLoanRepository.findAll();
    }

    @Override
    public BookLoan getById(Long id) {
        return bookLoanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book loan not found with id " + id));
    }

    @Override
    public List<BookLoan> getAllByUserId(Long userId) {
        return bookLoanRepository.findAllByUserId(userId);
    }

    @Override
    public BookLoan getByBookId(Long bookId) {
        return bookLoanRepository.findByBookId(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book loan not found with book id " + bookId));
    }

    private boolean isBookAlreadyLoaned(Long bookId) {
        return bookLoanRepository.existsByBookId(bookId);
    }

    @Override
    public BookLoan create(BookLoan bookLoan) {

        Book book = bookLoan.getBook();
        if(!bookService.existsById(book.getId())) {
            throw new IllegalArgumentException("Book with id " + book.getId() + " does not exist");
        }

        User user = bookLoan.getUser();
        if(!userService.existsById(user.getId())) {
            throw new IllegalArgumentException("User with id " + user.getId() + " does not exist");
        }

        if(isBookAlreadyLoaned(book.getId())) {
            throw new IllegalStateException("Book with id " + bookLoan.getBook().getId() + " is already loaned");
        }

        return bookLoanRepository.save(bookLoan);
    }

    @Override
    public void delete(Long id) {
        bookLoanRepository.deleteById(id);
    }
}

package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookLoanRepository
        extends JpaRepository<BookLoan, Long> {

    List<BookLoan> findAllByUserId(Long userId);

    Optional<BookLoan> findByBookId(Long bookId);

    boolean existsByBookId(Long bookId);

}

package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

}

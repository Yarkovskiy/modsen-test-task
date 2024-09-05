package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository
        extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    boolean existsById(Long id);

}

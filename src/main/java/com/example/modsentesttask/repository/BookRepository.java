package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

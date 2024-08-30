package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}

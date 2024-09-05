package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByIdIn(List<Long> ids);

    List<Author> findAllByName(String name);

}

package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}

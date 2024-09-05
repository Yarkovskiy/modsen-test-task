package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.book.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllByIdIn(List<Long> ids);

    Optional<Genre> findByName(String name);

    boolean existsByName(String name);

}

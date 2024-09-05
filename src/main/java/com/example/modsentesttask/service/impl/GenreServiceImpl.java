package com.example.modsentesttask.service.impl;

import com.example.modsentesttask.domain.book.Genre;
import com.example.modsentesttask.domain.exception.ResourceNotFoundException;
import com.example.modsentesttask.repository.GenreRepository;
import com.example.modsentesttask.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> getAllByIdIn(List<Long> ids) {
        return genreRepository.findAllByIdIn(ids);
    }

    @Override
    public Genre getById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
    }

    @Override
    public Genre getByName(String name) {
        return genreRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with name: " + name));
    }

    @Override
    public Genre create(Genre genre) {
        if (genreRepository.existsByName(genre.getName())) {
            throw new IllegalArgumentException("Genre with name: " + genre.getName() + " already exists");
        }
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(Genre genre) {
        Genre existingGenre = getById(genre.getId());

        if (!existingGenre.getName().equals(genre.getName())) {
            if (genreRepository.existsByName(genre.getName())) {
                throw new IllegalArgumentException("Genre with name: " + genre.getName() + " already exists");
            }
            existingGenre.setName(genre.getName());
        }

        return genreRepository.save(existingGenre);
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}

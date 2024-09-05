package com.example.modsentesttask.service.impl;

import com.example.modsentesttask.domain.book.Author;
import com.example.modsentesttask.domain.exception.ResourceNotFoundException;
import com.example.modsentesttask.repository.AuthorRepository;
import com.example.modsentesttask.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAllByIdIn(List<Long> ids) {
        return authorRepository.findAllByIdIn(ids);
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
    }

    @Override
    public List<Author> getByName(String name) {
        return authorRepository.findAllByName(name);
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        Author existingAuthor = getById(author.getId());
        existingAuthor.setName(author.getName());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}

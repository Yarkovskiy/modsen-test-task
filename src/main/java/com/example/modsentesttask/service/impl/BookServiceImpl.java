package com.example.modsentesttask.service.impl;

import com.example.modsentesttask.domain.book.Author;
import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.domain.book.Genre;
import com.example.modsentesttask.domain.exception.ResourceNotFoundException;
import com.example.modsentesttask.repository.BookRepository;
import com.example.modsentesttask.service.AuthorService;
import com.example.modsentesttask.service.BookService;
import com.example.modsentesttask.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;
    private final GenreService genreService;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
    }

    @Override
    public Book getByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with isbn " + isbn));
    }

    @Override
    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }

    @Override
    @Transactional
    public Book create(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new IllegalArgumentException("ISBN already exists: " + book.getIsbn());
        }

        List<Author> authors = authorService.getAllByIdIn(
                book.getAuthors().stream()
                        .map(Author::getId)
                        .collect(Collectors.toList())
        );

        if (authors.size() != book.getAuthors().size()) {
            throw new ResourceNotFoundException("One or more authors not found");
        }

        List<Genre> genres = genreService.getAllByIdIn(
                book.getGenres().stream()
                        .map(Genre::getId)
                        .collect(Collectors.toList())
        );

        if (genres.size() != book.getGenres().size()) {
            throw new ResourceNotFoundException("One or more genres not found");
        }

        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book update(Book book) {
        Book existingBook = getById(book.getId());

        if (!existingBook.getIsbn().equals(book.getIsbn())) {
            if (bookRepository.existsByIsbn(book.getIsbn())) {
                throw new IllegalArgumentException("ISBN already exists: " + book.getIsbn());
            }
            existingBook.setIsbn(book.getIsbn());
        }

        existingBook.setTitle(book.getTitle());
        existingBook.setDescription(book.getDescription());

        List<Author> authors = authorService.getAllByIdIn(
                book.getAuthors().stream()
                        .map(Author::getId)
                        .collect(Collectors.toList())
        );
        if (authors.size() != book.getAuthors().size()) {
            throw new ResourceNotFoundException("One or more authors not found");
        }
        existingBook.setAuthors(authors);


        List<Genre> genres = genreService.getAllByIdIn(
                book.getGenres().stream()
                        .map(Genre::getId)
                        .collect(Collectors.toList())
        );
        if (genres.size() != book.getGenres().size()) {
            throw new ResourceNotFoundException("One or more genres not found");
        }
        existingBook.setGenres(genres);

        return bookRepository.save(existingBook);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}

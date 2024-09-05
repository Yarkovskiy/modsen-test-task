package com.example.modsentesttask.web.controller;

import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.service.BookService;
import com.example.modsentesttask.service.impl.AuthorServiceImpl;
import com.example.modsentesttask.service.impl.GenreServiceImpl;
import com.example.modsentesttask.web.dto.request.BookRequestDto;
import com.example.modsentesttask.web.dto.response.BookResponseDto;
import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.dto.validation.OnUpdate;
import com.example.modsentesttask.web.mapper.BookMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "2. Book Controller",
        description = "Operations related to books"
)
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    private final GenreServiceImpl genreServiceImpl;
    private final AuthorServiceImpl authorServiceImpl;

    @Operation(summary = "Get all books")
    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return bookMapper.toResponseDto(books);
    }

    @Operation(summary = "Get book by ID")
    @GetMapping("/{id}")
    public BookResponseDto getBookById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        Book book = bookService.getById(id);
        return bookMapper.toResponseDto(book);
    }

    @Operation(summary = "Get book by ISBN")
    @GetMapping("/search")
    public BookResponseDto getBookByIsbn(
            @Parameter(description = "ISBN of the book", example = "0-123-45678-9")
                @Pattern(regexp = "^(\\d-\\d{3}-\\d{5}-\\d)$",
                    message = "{isbn.invalid}")
                @RequestParam String isbn
    ) {
        Book book = bookService.getByIsbn(isbn);
        return bookMapper.toResponseDto(book);
    }

    @Operation(summary = "Create new book")
    @PreAuthorize("@customSecurityExpression.hasRoleAdmin()")
    @PostMapping
    public BookResponseDto createBook(
            @Validated(OnCreate.class)
                @RequestBody BookRequestDto bookRequestDto
    ) {
        Book book = bookMapper.toEntity(bookRequestDto, genreServiceImpl, authorServiceImpl);

        Book createdBook = bookService.create(book);
        return bookMapper.toResponseDto(createdBook);
    }

    @Operation(summary = "Update book by ID")
    @PreAuthorize("@customSecurityExpression.hasRoleAdmin()")
    @PutMapping("/{id}")
    public BookResponseDto updateBookById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id,
            @Validated(OnUpdate.class)
                @RequestBody BookRequestDto bookRequestDto
    ) {
        Book book = bookMapper.toEntity(bookRequestDto, genreServiceImpl, authorServiceImpl);
        book.setId(id);

        Book updatedBook = bookService.update(book);
        return bookMapper.toResponseDto(updatedBook);
    }

    @Operation(summary = "Delete book by ID")
    @PreAuthorize("@customSecurityExpression.hasRoleAdmin()")
    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id) {
        bookService.delete(id);
    }

}

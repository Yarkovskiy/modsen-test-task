package com.example.modsentesttask.web.controller;

import com.example.modsentesttask.domain.book.BookLoan;
import com.example.modsentesttask.service.BookLoanService;
import com.example.modsentesttask.service.BookService;
import com.example.modsentesttask.service.UserService;
import com.example.modsentesttask.web.dto.request.BookLoanRequestDto;
import com.example.modsentesttask.web.dto.response.BookLoanResponseDto;
import com.example.modsentesttask.web.dto.validation.OnCreate;
import com.example.modsentesttask.web.mapper.BookLoanMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loans")
@Validated
@Tag(
        name = "5. BookLoan Controller",
        description = "Operations related to loans of books"
)
public class BookLoanController {

    private final BookLoanService bookLoanService;
    private final BookService bookService;
    private final UserService userService;
    private final BookLoanMapper bookLoanMapper;

    @Operation(summary = "Get all book loans")
    @GetMapping
    List<BookLoanResponseDto> getAllBookLoans() {
        List<BookLoan> bookLoans = bookLoanService.getAll();
        return bookLoanMapper.toResponseDto(bookLoans);
    }

    @Operation(summary = "Get book loan by ID")
    @GetMapping("/{id}")
    BookLoanResponseDto getBookLoanById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        BookLoan bookLoan = bookLoanService.getById(id);
        return bookLoanMapper.toResponseDto(bookLoan);
    }

    @Operation(summary = "Get book loan by user's ID")
    @GetMapping("/user/{id}")
    List<BookLoanResponseDto> getBookLoanByUserId(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        List<BookLoan> bookLoans = bookLoanService.getAllByUserId(id);
        return bookLoanMapper.toResponseDto(bookLoans);
    }

    @Operation(summary = "Get book loan by book ID")
    @GetMapping("/book/{id}")
    BookLoanResponseDto getBookLoanByBookId(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        BookLoan bookLoan = bookLoanService.getByBookId(id);
        return bookLoanMapper.toResponseDto(bookLoan);
    }

    @Operation(summary = "Create new book loan")
    @PostMapping()
    public BookLoanResponseDto createBookLoan(
            @Validated(OnCreate.class)
                @RequestBody BookLoanRequestDto bookLoanRequestDto
    ) {
        BookLoan bookLoan = bookLoanMapper.toEntity(bookLoanRequestDto, bookService, userService);

        BookLoan createdBookLoan = bookLoanService.create(bookLoan);
        return bookLoanMapper.toResponseDto(createdBookLoan);
    }

    @Operation(summary = "Delete book loan by ID")
    @DeleteMapping("/{id}")
    void deleteBookLoanById(
            @PathVariable
                @Positive(message = "{general.id.positive}") Long id
    ) {
        bookLoanService.delete(id);
    }

}

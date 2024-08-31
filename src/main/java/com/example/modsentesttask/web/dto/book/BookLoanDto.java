package com.example.modsentesttask.web.dto.book;

import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.domain.user.User;

import java.time.LocalDateTime;

public record BookLoanDto(

        Long id,
        Book book,
        User user,
        LocalDateTime borrowedTime,
        LocalDateTime returnTime
) {
}

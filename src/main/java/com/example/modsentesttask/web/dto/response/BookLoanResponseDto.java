package com.example.modsentesttask.web.dto.response;

import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.domain.user.User;

import java.time.LocalDateTime;

public record BookLoanResponseDto(

        Long id,
        Book book,
        User user,
        LocalDateTime borrowedTime,
        LocalDateTime returnTime
) {
}

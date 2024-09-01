package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.book.BookLoan;
import com.example.modsentesttask.web.dto.request.BookLoanRequestDto;
import com.example.modsentesttask.web.dto.response.BookLoanResponseDto;

public interface BookLoanMapper
        extends Mappable<BookLoan, BookLoanRequestDto, BookLoanResponseDto> {
}

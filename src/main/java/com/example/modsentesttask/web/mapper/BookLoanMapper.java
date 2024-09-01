package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.book.BookLoan;
import com.example.modsentesttask.web.dto.request.BookLoanRequestDto;
import com.example.modsentesttask.web.dto.response.BookLoanResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookLoanMapper
        extends Mappable<BookLoan, BookLoanRequestDto, BookLoanResponseDto> {
}

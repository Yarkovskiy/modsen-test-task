package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.web.dto.request.BookRequestDto;
import com.example.modsentesttask.web.dto.response.BookResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper
        extends Mappable<Book, BookRequestDto, BookResponseDto> {

}

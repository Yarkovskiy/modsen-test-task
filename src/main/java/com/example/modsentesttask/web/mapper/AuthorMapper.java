package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.book.Author;
import com.example.modsentesttask.web.dto.request.AuthorRequestDto;
import com.example.modsentesttask.web.dto.response.AuthorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper
        extends Mappable<Author, AuthorRequestDto, AuthorResponseDto> {

}

package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.book.Genre;
import com.example.modsentesttask.web.dto.response.GenreResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper extends Mappable<Genre, GenreResponseDto> {

}

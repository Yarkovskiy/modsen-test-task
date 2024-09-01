package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.user.User;
import com.example.modsentesttask.web.dto.request.UserRequestDto;
import com.example.modsentesttask.web.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper
        extends Mappable<User, UserRequestDto, UserResponseDto> {

}

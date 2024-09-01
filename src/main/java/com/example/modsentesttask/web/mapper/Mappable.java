package com.example.modsentesttask.web.mapper;

import java.util.List;

public interface Mappable<E, ReqD, ResD> {

    ResD toResponseDto(E entity);

    List<ResD> toResponseDto(List<E> entities);

    E toEntity(ReqD dto);

}

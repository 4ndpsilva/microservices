package com.devsuperior.hrworker.mapper;

import com.devsuperior.hrworker.dto.BaseDTO;
import com.devsuperior.hrworker.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<D extends BaseDTO, T extends BaseEntity> {
    T toEntity(D dto);
    D toDTO(T entity);
    List<D> toListDTO(List<T> entities);
}
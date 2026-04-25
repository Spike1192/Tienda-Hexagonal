package com.ing_hexagonal.application.mapper;

import com.ing_hexagonal.application.dto.request.ProductoRequestDto;
import com.ing_hexagonal.application.dto.response.ProductoResponseDto;
import com.ing_hexagonal.domain.model.ProductoModel;

public class ProductoMapper {

    // DTO Request → Domain Model
    public static ProductoModel toModel(ProductoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new ProductoModel(
                dto.getNombre(),
                dto.getCantidad(),
                dto.getPrecio(),
                dto.getCategoriaId()
        );
    }

    // Domain Model → DTO Response
    public static ProductoResponseDto toResponse(ProductoModel model) {
        if (model == null) {
            return null;
        }

        return new ProductoResponseDto(
                model.getId(),
                model.getNombre(),
                model.getCantidad(),
                model.getPrecio(),
                model.getCategoriaId()
        );
    }
}
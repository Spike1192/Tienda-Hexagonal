package com.ing_hexagonal.domain.spi;

import java.util.List;
import com.ing_hexagonal.domain.model.ProductoModel;

public interface IProductoPersistencePort {

    ProductoModel save(ProductoModel producto);

    ProductoModel update(ProductoModel producto);

    void deleteById(Integer id);

    ProductoModel getById(Integer id);

    List<ProductoModel> getAll();
}
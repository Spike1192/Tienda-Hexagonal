package com.ing_hexagonal.domain.api;

import java.util.List;
import com.ing_hexagonal.domain.model.ProductoModel;

public interface IProductoServicePort {

    void save(ProductoModel producto);

    void update(ProductoModel producto);

    void delete(ProductoModel producto);

    List<ProductoModel> getAll();

    
    ProductoModel getById(Integer id);

    void deleteById(Integer id);
}
package com.ing_hexagonal.infrastructure.output.jpa.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ing_hexagonal.domain.model.ProductoModel;
import com.ing_hexagonal.domain.spi.IProductoPersistencePort;
import com.ing_hexagonal.infrastructure.output.jpa.entity.ProductoEntity;
import com.ing_hexagonal.infrastructure.output.jpa.repository.IProductoRepository;

@Component
public class ProductoJpaAdapter implements IProductoPersistencePort {

    private final IProductoRepository productoRepository;

    public ProductoJpaAdapter(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoModel save(ProductoModel producto) {
        ProductoEntity entity = toEntity(producto);
        ProductoEntity saved = productoRepository.save(entity);
        return toModel(saved);
    }

    @Override
    public ProductoModel update(ProductoModel producto) {
        ProductoEntity entity = toEntity(producto);
        ProductoEntity updated = productoRepository.save(entity);
        return toModel(updated);
    }

    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoModel getById(Integer id) {
        ProductoEntity entity = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        return toModel(entity);
    }

    @Override
    public List<ProductoModel> getAll() {
        return productoRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private ProductoEntity toEntity(ProductoModel model) {
        return new ProductoEntity(
                model.getId(),
                model.getNombre(),
                model.getCantidad(),
                model.getPrecio(),
                model.getCategoriaId()
        );
    }

    private ProductoModel toModel(ProductoEntity entity) {
        return new ProductoModel(
                entity.getId(),
                entity.getNombre(),
                entity.getCantidad(),
                entity.getPrecio(),
                entity.getCategoriaId()
        );
    }
}
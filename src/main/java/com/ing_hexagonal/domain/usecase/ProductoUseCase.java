package com.ing_hexagonal.domain.usecase;

import java.util.List;

import com.ing_hexagonal.domain.api.IProductoServicePort;
import com.ing_hexagonal.domain.exception.DomainException;
import com.ing_hexagonal.domain.model.ProductoModel;
import com.ing_hexagonal.domain.spi.IProductoPersistencePort;

public class ProductoUseCase implements IProductoServicePort {

    private final IProductoPersistencePort productoPersistencePort;

    public ProductoUseCase(IProductoPersistencePort productoPersistencePort) {
        if (productoPersistencePort == null) {
            throw new DomainException("El puerto de persistencia no puede ser nulo");
        }
        this.productoPersistencePort = productoPersistencePort;
    }

    @Override
    public void save(ProductoModel producto) {
        validate(producto);
        productoPersistencePort.save(producto);
    }

    @Override
    public void update(ProductoModel producto) {
        validate(producto);

        if (producto.getId() == null) {
            throw new DomainException("El ID es obligatorio para actualizar");
        }

        productoPersistencePort.update(producto);
    }

    @Override
    public void delete(ProductoModel producto) {
        if (producto == null || producto.getId() == null) {
            throw new DomainException("El producto o su ID no pueden ser nulos");
        }

        productoPersistencePort.deleteById(producto.getId());
    }

    @Override
    public List<ProductoModel> getAll() {
        return productoPersistencePort.getAll();
    }

    
    @Override
    public ProductoModel getById(Integer id) {
        if (id == null) {
            throw new DomainException("El ID no puede ser nulo");
        }
        return productoPersistencePort.getById(id);
    }

    
    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw new DomainException("El ID no puede ser nulo");
        }
        productoPersistencePort.deleteById(id);
    }

    private void validate(ProductoModel producto) {
        if (producto == null) {
            throw new DomainException("El producto no puede ser nulo");
        }

        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new DomainException("El nombre es obligatorio");
        }

        if (producto.getCantidad() < 0) {
            throw new DomainException("La cantidad no puede ser negativa");
        }

        if (producto.getPrecio() <= 0) {
            throw new DomainException("El precio debe ser mayor a cero");
        }
    }
}
package co.com.hexagonal.domain.usecase;

import java.util.List;
import co.com.hexagonal.domain.api.IProductosServicePort;
import co.com.hexagonal.domain.exception.ProductosValidationException;
import co.com.hexagonal.domain.model.ProductosModel;
import co.com.hexagonal.domain.spi.IProductosPersistencePort;

public class ProductosUseCase implements IProductosServicePort {

    private final IProductosPersistencePort productosPersistencePort;

    public ProductosUseCase(IProductosPersistencePort productosPersistencePort) {
        if (productosPersistencePort == null) {
            throw new ProductosValidationException("El puerto de persistencia de productos no puede ser nulo");
        }
        this.productosPersistencePort = productosPersistencePort;
    }

    @Override
    public void save(ProductosModel productos) {
        validate(productos);
        productosPersistencePort.save(productos);
    }

    @Override
    public void update(ProductosModel productos) {
        validate(productos);
        productosPersistencePort.update(productos);
    }

    @Override
    public void delete(ProductosModel productos) {
        validateNotNull(productos, "El producto no puede ser nulo");
        productosPersistencePort.delete(productos);
    }

    @Override
    public List<ProductosModel> getAll() {
        return productosPersistencePort.getAll();
    }

    private void validate(ProductosModel productos) {
        validateNotNull(productos, "El producto no puede ser nulo");
        if (isBlank(productos.getNomprod())) {
            throw new ProductosValidationException("El nombre del producto es obligatorio");
        }
        if (productos.getCantprod() < 0) {
            throw new ProductosValidationException("La cantidad del producto no puede ser negativa");
        }
        if (productos.getPrecio() <= 0) {
            throw new ProductosValidationException("El precio del producto debe ser mayor a cero");
        }
    }

    private void validateNotNull(Object value, String message) {
        if (value == null) {
            throw new ProductosValidationException(message);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

package co.com.hexagonal.domain.usecase;

import java.util.List;
import co.com.hexagonal.domain.api.IDetalleVentaServicePort;
import co.com.hexagonal.domain.exception.DetalleVentaValidationException;
import co.com.hexagonal.domain.model.DetalleVentaModel;
import co.com.hexagonal.domain.spi.IDetalleVentaPersistencePort;

public class DetalleVentaUseCase implements IDetalleVentaServicePort {

    private final IDetalleVentaPersistencePort detalleVentaPersistencePort;

    public DetalleVentaUseCase(IDetalleVentaPersistencePort detalleVentaPersistencePort) {
        if (detalleVentaPersistencePort == null) {
            throw new DetalleVentaValidationException("El puerto de persistencia de detalle de venta no puede ser nulo");
        }
        this.detalleVentaPersistencePort = detalleVentaPersistencePort;
    }

    @Override
    public void save(DetalleVentaModel detalleVenta) {
        validate(detalleVenta);
        detalleVentaPersistencePort.save(detalleVenta);
    }

    @Override
    public void update(DetalleVentaModel detalleVenta) {
        validate(detalleVenta);
        detalleVentaPersistencePort.update(detalleVenta);
    }

    @Override
    public void delete(DetalleVentaModel detalleVenta) {
        validateNotNull(detalleVenta, "El detalle de venta no puede ser nulo");
        detalleVentaPersistencePort.delete(detalleVenta);
    }

    @Override
    public List<DetalleVentaModel> getAll() {
        return detalleVentaPersistencePort.getAll();
    }

    private void validate(DetalleVentaModel detalleVenta) {
        validateNotNull(detalleVenta, "El detalle de venta no puede ser nulo");
        if (isBlank(detalleVenta.getProducto())) {
            throw new DetalleVentaValidationException("El producto del detalle de venta es obligatorio");
        }
        if (detalleVenta.getCantidad() <= 0) {
            throw new DetalleVentaValidationException("La cantidad del detalle de venta debe ser mayor a cero");
        }
        if (detalleVenta.getPrecio() <= 0) {
            throw new DetalleVentaValidationException("El precio del detalle de venta debe ser mayor a cero");
        }
    }

    private void validateNotNull(Object value, String message) {
        if (value == null) {
            throw new DetalleVentaValidationException(message);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

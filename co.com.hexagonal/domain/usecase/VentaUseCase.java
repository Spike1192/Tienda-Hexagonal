package co.com.hexagonal.domain.usecase;

import java.util.List;
import co.com.hexagonal.domain.api.IVentaServicePort;
import co.com.hexagonal.domain.exception.VentaValidationException;
import co.com.hexagonal.domain.model.VentaModel;
import co.com.hexagonal.domain.spi.IVentaPersistencePort;

public class VentaUseCase implements IVentaServicePort {

    private final IVentaPersistencePort ventaPersistencePort;

    public VentaUseCase(IVentaPersistencePort ventaPersistencePort) {
        if (ventaPersistencePort == null) {
            throw new VentaValidationException("El puerto de persistencia de venta no puede ser nulo");
        }
        this.ventaPersistencePort = ventaPersistencePort;
    }

    @Override
    public void save(VentaModel venta) {
        validate(venta);
        ventaPersistencePort.save(venta);
    }

    @Override
    public void update(VentaModel venta) {
        validate(venta);
        ventaPersistencePort.update(venta);
    }

    @Override
    public void delete(VentaModel venta) {
        validateNotNull(venta, "La venta no puede ser nula");
        ventaPersistencePort.delete(venta);
    }

    @Override
    public List<VentaModel> getAll() {
        return ventaPersistencePort.getAll();
    }

    private void validate(VentaModel venta) {
        validateNotNull(venta, "La venta no puede ser nula");
        if (isBlank(venta.getCliente())) {
            throw new VentaValidationException("El cliente de la venta es obligatorio");
        }
        if (venta.getTotal() <= 0) {
            throw new VentaValidationException("El total de la venta debe ser mayor a cero");
        }
    }

    private void validateNotNull(Object value, String message) {
        if (value == null) {
            throw new VentaValidationException(message);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

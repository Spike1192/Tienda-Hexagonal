package co.com.hexagonal.domain.usecase;

import java.util.List;
import co.com.hexagonal.domain.api.IObjectServicePort;
import co.com.hexagonal.domain.exception.DomainValidationException;
import co.com.hexagonal.domain.model.DetalleVentaModel;
import co.com.hexagonal.domain.model.LoginModel;
import co.com.hexagonal.domain.model.ProductosModel;
import co.com.hexagonal.domain.model.StatusModel;
import co.com.hexagonal.domain.model.VentaModel;
import co.com.hexagonal.domain.spi.IObjectPersistencePort;
import org.springframework.stereotype.Service;

public class ObjectUseCase implements IObjectServicePort {

    private final IObjectPersistencePort objectPersistencePort;

    public ObjectUseCase(IObjectPersistencePort objectPersistencePort) {
        if (objectPersistencePort == null) {
            throw new DomainValidationException("El puerto de persistencia no puede ser nulo");
        }
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public void saveStatus(StatusModel status) {
        validateStatus(status);
        objectPersistencePort.saveStatus(status);
    }

    @Override
    public void saveLogin(LoginModel login) {
        validateLogin(login);
        objectPersistencePort.saveLogin(login);
    }

    @Override
    public void saveProductos(ProductosModel productos) {
        validateProducto(productos);
        objectPersistencePort.saveProductos(productos);
    }

    @Override
    public void saveVenta(VentaModel venta) {
        validateVenta(venta);
        objectPersistencePort.saveVenta(venta);
    }

    @Override
    public void saveDetalleVenta(DetalleVentaModel detalleVenta) {
        validateDetalleVenta(detalleVenta);
        objectPersistencePort.saveDetalleVenta(detalleVenta);
    }

    @Override
    public void updateStatus(StatusModel status) {
        validateStatus(status);
        objectPersistencePort.updateStatus(status);
    }

    @Override
    public void updateLogin(LoginModel login) {
        validateLogin(login);
        objectPersistencePort.updateLogin(login);
    }

    @Override
    public void updateProductos(ProductosModel productos) {
        validateProducto(productos);
        objectPersistencePort.updateProductos(productos);
    }

    @Override
    public void updateVenta(VentaModel venta) {
        validateVenta(venta);
        objectPersistencePort.updateVenta(venta);
    }

    @Override
    public void updateDetalleVenta(DetalleVentaModel detalleVenta) {
        validateDetalleVenta(detalleVenta);
        objectPersistencePort.updateDetalleVenta(detalleVenta);
    }

    @Override
    public void deleteStatus(StatusModel status) {
        validateNotNull(status, "El estado no puede ser nulo");
        objectPersistencePort.deleteStatus(status);
    }

    @Override
    public void deleteLogin(LoginModel login) {
        validateNotNull(login, "El login no puede ser nulo");
        objectPersistencePort.deleteLogin(login);
    }

    @Override
    public void deleteProductos(ProductosModel productos) {
        validateNotNull(productos, "El producto no puede ser nulo");
        objectPersistencePort.deleteProductos(productos);
    }

    @Override
    public void deleteVenta(VentaModel venta) {
        validateNotNull(venta, "La venta no puede ser nula");
        objectPersistencePort.deleteVenta(venta);
    }

    @Override
    public void deleteDetalleVenta(DetalleVentaModel detalleVenta) {
        validateNotNull(detalleVenta, "El detalle de venta no puede ser nulo");
        objectPersistencePort.deleteDetalleVenta(detalleVenta);
    }

    @Override
    public List<StatusModel> getAllStatus() {
        return objectPersistencePort.getAllStatus();
    }

    @Override
    public List<LoginModel> getAllLogin() {
        return objectPersistencePort.getAllLogin();
    }

    @Override
    public List<ProductosModel> getAllProductos() {
        return objectPersistencePort.getAllProductos();
    }

    @Override
    public List<VentaModel> getAllVenta() {
        return objectPersistencePort.getAllVenta();
    }

    @Override
    public List<DetalleVentaModel> getAllDetalleVenta() {
        return objectPersistencePort.getAllDetalleVenta();
    }

    private void validateStatus(StatusModel status) {
        validateNotNull(status, "El estado no puede ser nulo");
        if (isBlank(status.getDstatus())) {
            throw new DomainValidationException("La descripcion del estado es obligatoria");
        }
    }

    private void validateLogin(LoginModel login) {
        validateNotNull(login, "El login no puede ser nulo");
        if (isBlank(login.getNombre())) {
            throw new DomainValidationException("El nombre del usuario es obligatorio");
        }
        if (isBlank(login.getUsuario())) {
            throw new DomainValidationException("El usuario es obligatorio");
        }
        if (isBlank(login.getClave())) {
            throw new DomainValidationException("La clave es obligatoria");
        }
    }

    private void validateProducto(ProductosModel productos) {
        validateNotNull(productos, "El producto no puede ser nulo");
        if (isBlank(productos.getNomprod())) {
            throw new DomainValidationException("El nombre del producto es obligatorio");
        }
        if (productos.getCantprod() < 0) {
            throw new DomainValidationException("La cantidad del producto no puede ser negativa");
        }
        if (productos.getPrecio() <= 0) {
            throw new DomainValidationException("El precio del producto debe ser mayor a cero");
        }
    }

    private void validateVenta(VentaModel venta) {
        validateNotNull(venta, "La venta no puede ser nula");
        if (isBlank(venta.getCliente())) {
            throw new DomainValidationException("El cliente de la venta es obligatorio");
        }
        if (venta.getTotal() <= 0) {
            throw new DomainValidationException("El total de la venta debe ser mayor a cero");
        }
    }

    private void validateDetalleVenta(DetalleVentaModel detalleVenta) {
        validateNotNull(detalleVenta, "El detalle de venta no puede ser nulo");
        if (isBlank(detalleVenta.getProducto())) {
            throw new DomainValidationException("El producto del detalle de venta es obligatorio");
        }
        if (detalleVenta.getCantidad() <= 0) {
            throw new DomainValidationException("La cantidad del detalle de venta debe ser mayor a cero");
        }
        if (detalleVenta.getPrecio() <= 0) {
            throw new DomainValidationException("El precio del detalle de venta debe ser mayor a cero");
        }
    }

    private void validateNotNull(Object obj, String message) {
        if (obj == null) {
            throw new DomainValidationException(message);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

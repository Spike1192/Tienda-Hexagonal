package co.com.hexagonal.domain.spi;

import java.util.List;
import co.com.hexagonal.domain.model.DetalleVentaModel;

public interface IDetalleVentaPersistencePort {

    DetalleVentaModel save(DetalleVentaModel detalleVenta);

    DetalleVentaModel update(DetalleVentaModel detalleVenta);

    void delete(DetalleVentaModel detalleVenta);

    List<DetalleVentaModel> getAll();
}

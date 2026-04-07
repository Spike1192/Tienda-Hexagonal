package co.com.hexagonal.domain.api;

import java.util.List;
import co.com.hexagonal.domain.model.DetalleVentaModel;

public interface IDetalleVentaServicePort {

    void save(DetalleVentaModel detalleVenta);

    void update(DetalleVentaModel detalleVenta);

    void delete(DetalleVentaModel detalleVenta);

    List<DetalleVentaModel> getAll();
}

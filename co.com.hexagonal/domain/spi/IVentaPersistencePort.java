package co.com.hexagonal.domain.spi;

import java.util.List;
import co.com.hexagonal.domain.model.VentaModel;

public interface IVentaPersistencePort {

    VentaModel save(VentaModel venta);

    VentaModel update(VentaModel venta);

    void delete(VentaModel venta);

    List<VentaModel> getAll();
}

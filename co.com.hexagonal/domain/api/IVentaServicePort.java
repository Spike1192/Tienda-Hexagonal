package co.com.hexagonal.domain.api;

import java.util.List;
import co.com.hexagonal.domain.model.VentaModel;

public interface IVentaServicePort {

    void save(VentaModel venta);

    void update(VentaModel venta);

    void delete(VentaModel venta);

    List<VentaModel> getAll();
}

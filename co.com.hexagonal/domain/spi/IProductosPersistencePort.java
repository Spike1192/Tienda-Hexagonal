package co.com.hexagonal.domain.spi;

import java.util.List;
import co.com.hexagonal.domain.model.ProductosModel;

public interface IProductosPersistencePort {

    ProductosModel save(ProductosModel productos);

    ProductosModel update(ProductosModel productos);

    void delete(ProductosModel productos);

    List<ProductosModel> getAll();
}

package co.com.hexagonal.domain.api;

import java.util.List;
import co.com.hexagonal.domain.model.ProductosModel;

public interface IProductosServicePort {

    void save(ProductosModel productos);

    void update(ProductosModel productos);

    void delete(ProductosModel productos);

    List<ProductosModel> getAll();
}

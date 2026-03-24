import java.util.List;
import co.com.hexagonal.domain.model.StatusModel;
import co.com.hexagonal.domain.model.LoginModel;
import co.com.hexagonal.domain.model.ProductosModel;
import co.com.hexagonal.domain.model.VentaModel;
import co.com.hexagonal.domain.model.DetalleVentaModel;

public interface IObjectServicePort {

    void saveStatus(StatusModel status);

    void saveLogin(LoginModel login);

    void saveProductos(ProductosModel productos);

    void saveVenta(VentaModel venta);

    void saveDetalleVenta(DetalleVentaModel detalleVenta);

    void updateStatus(StatusModel status);

    void updateLogin(LoginModel login);

    void updateProductos(ProductosModel productos);

    void updateVenta(VentaModel venta);

    void updateDetalleVenta(DetalleVentaModel detalleVenta);

    void deleteStatus(StatusModel status);

    void deleteLogin(LoginModel login);

    void deleteProductos(ProductosModel productos);

    void deleteVenta(VentaModel venta);

    void deleteDetalleVenta(DetalleVentaModel detalleVenta);

    List<StatusModel> getAllStatus();

    List<LoginModel> getAllLogin();

    List<ProductosModel> getAllProductos();

    List<VentaModel> getAllVenta();

    List<DetalleVentaModel> getAllDetalleVenta();
}

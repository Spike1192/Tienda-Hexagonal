import java.util.List;
import co.com.hexagonal.domain.model.StatusModel;
import co.com.hexagonal.domain.model.LoginModel;
import co.com.hexagonal.domain.model.ProductosModel;
import co.com.hexagonal.domain.model.VentaModel;
import co.com.hexagonal.domain.model.DetalleVentaModel;

public interface IObjectPersistencePort {

    StatusModel saveStatus(StatusModel status);

    LoginModel saveLogin(LoginModel login);

    ProductosModel saveProductos(ProductosModel productos);

    VentaModel saveVenta(VentaModel venta);

    DetalleVentaModel saveDetalleVenta(DetalleVentaModel detalleVenta);

    StatusModel updateStatus(StatusModel status);

    LoginModel updateLogin(LoginModel login);

    ProductosModel updateProductos(ProductosModel productos);

    VentaModel updateVenta(VentaModel venta);

    DetalleVentaModel updateDetalleVenta(DetalleVentaModel detalleVenta);

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

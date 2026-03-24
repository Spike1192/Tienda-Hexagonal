public class DetalleVentaModel {
    private int id;
    private String producto;
    private int cantidad;
    private double precio;
    private int fknv;
    private int fkcods;

    public DetalleVentaModel(int id, String producto, int cantidad, double precio, int fknv, int fkcods) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fknv = fknv;
        this.fkcods = fkcods;
    }

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getFknv() {
        return fknv;
    }

    public int getFkcods() {
        return fkcods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFknv(int fknv) {
        this.fknv = fknv;
    }

    public void setFkcods(int fkcods) {
        this.fkcods = fkcods;
    }
}

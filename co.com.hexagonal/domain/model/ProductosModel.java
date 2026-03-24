package co.com.hexagonal.domain.model;

public class ProductosModel {
    private int codprod;
    private String nomprod;
    private int cantprod;
    private double precio;
    private int fkcods;

    public ProductosModel(int codprod, String nomprod, int cantprod, double precio, int fkcods) {
        this.codprod = codprod;
        this.nomprod = nomprod;
        this.cantprod = cantprod;
        this.precio = precio;
        this.fkcods = fkcods;
    }

    public int getCodprod() {
        return codprod;
    }

    public String getNomprod() {
        return nomprod;
    }

    public int getCantprod() {
        return cantprod;
    }

    public double getPrecio() {
        return precio;
    }

    public int getFkcods() {
        return fkcods;
    }

    public void setCodprod(int codprod) {
        this.codprod = codprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public void setCantprod(int cantprod) {
        this.cantprod = cantprod;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFkcods(int fkcods) {
        this.fkcods = fkcods;
    }
}

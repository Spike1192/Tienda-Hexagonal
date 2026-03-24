public class VentaModel {
    private int nv;
    private String cliente;
    private double total;
    private int fkcods;

    public VentaModel(int nv, String cliente, double total, int fkcods) {
        this.nv = nv;
        this.cliente = cliente;
        this.total = total;
        this.fkcods = fkcods;
    }

    public int getNv() {
        return nv;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public int getFkcods() {
        return fkcods;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setFkcods(int fkcods) {
        this.fkcods = fkcods;
    }
}

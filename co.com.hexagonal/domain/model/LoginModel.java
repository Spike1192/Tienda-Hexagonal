package co.com.hexagonal.domain.model;

public class LoginModel {
    private int id;
    private String nombre;
    private String usuario;
    private String clave;
    private int fkcods;

    public LoginModel() {
    }

    public LoginModel(String nombre, String usuario, String clave, int fkcods) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.fkcods = fkcods;
    }

    public LoginModel(int id, String nombre, String usuario, String clave, int fkcods) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.fkcods = fkcods;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public int getFkcods() {
        return fkcods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setFkcods(int fkcods) {
        this.fkcods = fkcods;
    }
}
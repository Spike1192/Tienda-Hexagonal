package com.ing_hexagonal.domain.model;

public class ProductoModel {

    private Integer id;
    private String nombre;
    private int cantidad;
    private double precio;
    private Integer categoriaId;

    public ProductoModel() {
    }

    public ProductoModel(Integer id, String nombre, int cantidad, double precio, Integer categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoriaId = categoriaId;
    }

    public ProductoModel(String nombre, int cantidad, double precio, Integer categoriaId) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoriaId = categoriaId;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}
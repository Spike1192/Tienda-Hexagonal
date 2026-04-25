package com.ing_hexagonal.application.dto.request;

public class ProductoRequestDto {

    private String nombre;
    private int cantidad;
    private double precio;
    private Integer categoriaId;

    public ProductoRequestDto() {
    }

    public ProductoRequestDto(String nombre, int cantidad, double precio, Integer categoriaId) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoriaId = categoriaId;
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
}

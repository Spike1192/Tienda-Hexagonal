package com.ing_hexagonal.application.dto.response;

public class ProductoResponseDto {

    private Integer id;
    private String nombre;
    private int cantidad;
    private double precio;
    private Integer categoriaId;

    public ProductoResponseDto() {
    }

    public ProductoResponseDto(Integer id, String nombre, int cantidad, double precio, Integer categoriaId) {
        this.id = id;
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
}
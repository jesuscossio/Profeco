package com.profeco.precios.modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jesus
 */
public class Precio {
    public Long id;
    public Long idProducto;
    public String supermercado;
    public double precio;

    public Precio(Long id, float precio) {
        this.id = id;
        this.precio = precio;
    }

    public Precio(Long id, Long idProducto, String supermercado, double precio) {
        this.id = id;
        this.idProducto = idProducto;
        this.supermercado = supermercado;
        this.precio = precio;
    }
    
    

    public Precio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(String supermercado) {
        this.supermercado = supermercado;
    }
    
    
    
    @Override
    public String toString() {
        return "Precio{"
                + "id=" + id
                + ", idProducto=" + idProducto
                + ", supermercado='" + supermercado + '\''
                + ", precio=" + precio
                + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.productos.servicio;
import com.profeco.productos.modelo.Producto;
import com.profeco.productos.repositorio.ProductoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jesus
 */
@Service
public class ProductoServicio {
    private final ProductoRepositorio productoRepository;

    public ProductoServicio(ProductoRepositorio productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Crear o actualizar un producto
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Buscar un producto por ID
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Buscar un producto por nombre
    public Producto obtenerPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    // Eliminar un producto
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}

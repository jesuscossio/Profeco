/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.productos.controlador;


import com.profeco.productos.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
      // Simulación de base de datos
    private ArrayList<Producto> productos = new ArrayList<>();
    public ProductoControlador() {
        // Datos iniciales de ejemplo
        productos.add(new Producto(1L, "Manzanas", "Manzanas frescas y jugosas"));
        productos.add(new Producto(2L, "Cereal", "Cereal integral con frutas secas"));
        productos.add(new Producto(3L, "Leche", "Leche descremada de 1 litro"));
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productos;
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        producto.setId((long) (productos.size() + 1)); // Generar ID simple
        productos.add(producto);
        return producto;
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productos.removeIf(producto -> producto.getId().equals(id));
        return eliminado ? "Producto eliminado" : "Producto no encontrado";
    }
}

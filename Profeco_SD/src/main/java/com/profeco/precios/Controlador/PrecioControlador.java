package com.profeco.precios.Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.profeco.precios.modelo.Precio;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus
 */

@RestController
@RequestMapping("/precios")

public class PrecioControlador {

    private List<Precio> precios = new ArrayList<>();

    public PrecioControlador() {
        // Datos iniciales de ejemplo
        precios.add(new Precio(1L, 1L, "Supermercado A", 25.99));
        precios.add(new Precio(2L, 2L, "Supermercado B", 45.50));
        precios.add(new Precio(3L, 3L, "Supermercado C", 18.30));
    }

    // Endpoint para listar todos los precios
    @GetMapping
    public List<Precio> listarPrecios() {
        return precios;
    }

    // Endpoint para obtener un precio por ID
    @GetMapping("/{id}")
    public Precio obtenerPrecioPorId(@PathVariable Long id) {
        return precios.stream()
                .filter(precio -> precio.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Endpoint para agregar un nuevo precio
    @PostMapping
    public Precio agregarPrecio(@RequestBody Precio precio) {
        precio.setId((long) (precios.size() + 1)); // Generar ID simple
        precios.add(precio);
        return precio;
    }

    // Endpoint para actualizar un precio existente
    @PutMapping("/{id}")
    public Precio actualizarPrecio(@PathVariable Long id, @RequestBody Precio precioActualizado) {
        for (Precio precio : precios) {
            if (precio.getId().equals(id)) {
                precio.setIdProducto(precioActualizado.getIdProducto());
                precio.setSupermercado(precioActualizado.getSupermercado());
                precio.setPrecio(precioActualizado.getPrecio());
                return precio;
            }
        }
        return null;
    }

    // Endpoint para eliminar un precio por ID
    @DeleteMapping("/{id}")
    public String eliminarPrecio(@PathVariable Long id) {
        boolean eliminado = precios.removeIf(precio -> precio.getId().equals(id));
        return eliminado ? "Precio eliminado" : "Precio no encontrado";
    }
}


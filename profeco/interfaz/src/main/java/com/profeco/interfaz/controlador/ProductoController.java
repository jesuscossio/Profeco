/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.interfaz.controlador;
import com.profeco.interfaz.modelo.Producto;
import com.profeco.interfaz.servicio.ProductoServicio;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


import java.util.List;
/**
 *
 * @author Jesus
 */
public class ProductoController {
    @FXML
    private ListView<String> productosList;

    private final ProductoServicio productosService = new ProductoServicio();

    @FXML
    public void initialize() {
        List<Producto> productos = productosService.obtenerProductos();
        for (Producto producto : productos) {
            productosList.getItems().add(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }
}

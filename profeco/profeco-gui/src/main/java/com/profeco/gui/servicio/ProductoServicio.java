/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.gui.servicio;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profeco.gui.modelo.Producto;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
/**
 *
 * @author Jesus
 */
public class ProductoServicio {
    private final String baseUrl = "http://localhost:8081/productos";

    public List<Producto> obtenerProductos() {
        try {
            URL url = new URL(baseUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(connection.getInputStream(), new TypeReference<List<Producto>>() {});
        } catch (IOException e) {
            return null;
        }
    }
}

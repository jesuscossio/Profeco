/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.notificaciones.controlador;

import com.profeco.notificaciones.modelo.Notificacion;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus
 */
@RestController
@RequestMapping("/notificaciones")
public class NotificacionControlador {
    private List<Notificacion> notificaciones = new ArrayList<>();

    public NotificacionControlador() {
        // Datos de ejemplo
        notificaciones.add(new Notificacion(1L, 1L, "Oferta en Manzanas: 20% descuento", LocalDateTime.now(), false));
        notificaciones.add(new Notificacion(2L, 2L, "Baja de precio en Leche", LocalDateTime.now(), false));
    }

    @GetMapping
    public List<Notificacion> listarNotificaciones() {
        return notificaciones;
    }

    @GetMapping("/{idUsuario}")
    public List<Notificacion> listarNotificacionesPorUsuario(@PathVariable Long idUsuario) {
        List<Notificacion> resultado = new ArrayList<>();
        for (Notificacion notificacion : notificaciones) {
            if (notificacion.getIdUsuario().equals(idUsuario)) {
                resultado.add(notificacion);
            }
        }
        return resultado;
    }

    @PostMapping
    public Notificacion agregarNotificacion(@RequestBody Notificacion notificacion) {
        notificacion.setId((long) (notificaciones.size() + 1)); // Generar un ID único
        notificacion.setFechaHora(LocalDateTime.now());
        notificacion.setLeida(false); // Las nuevas notificaciones son no leídas por defecto
        notificaciones.add(notificacion);
        return notificacion;
    }

    @PutMapping("/{id}")
    public Notificacion marcarNotificacionComoLeida(@PathVariable Long id) {
        for (Notificacion notificacion : notificaciones) {
            if (notificacion.getId().equals(id)) {
                notificacion.setLeida(true);
                return notificacion;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarNotificacion(@PathVariable Long id) {
        boolean eliminado = notificaciones.removeIf(notificacion -> notificacion.getId().equals(id));
        return eliminado ? "Notificación eliminada" : "Notificación no encontrada";
    }
}

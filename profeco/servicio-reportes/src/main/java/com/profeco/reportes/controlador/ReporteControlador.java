/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.reportes.controlador;
import com.profeco.reportes.model.Reporte;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jesus
 */
@RestController
@RequestMapping("/reportes")
public class ReporteControlador {
    private final SimpMessagingTemplate messagingTemplate;
    private List<Reporte> reportes = new ArrayList<>();

    public ReporteControlador(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public ReporteControlador() {
        // Datos iniciales de ejemplo
        reportes.add(new Reporte(1L, 1L, 101L, "Precio incorrecto reportado en Supermercado A", LocalDateTime.now(), false));
        reportes.add(new Reporte(2L, 2L, 102L, "Producto en mal estado encontrado en Supermercado B", LocalDateTime.now(), false));
        this.messagingTemplate = null;
    }

    // Listar todos los reportes
    @GetMapping
    public List<Reporte> listarReportes() {
        return reportes;
    }

    // Obtener un reporte por ID
    @GetMapping("/{id}")
    public Reporte obtenerReportePorId(@PathVariable Long id) {
        return reportes.stream()
                .filter(reporte -> reporte.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Agregar un nuevo reporte
    @PostMapping
    public Reporte agregarReporte(@RequestBody Reporte reporte) {
        reporte.setId((long) (reportes.size() + 1)); // Generar ID simple
        reporte.setFechaHora(LocalDateTime.now());
        reporte.setResuelto(false); // Por defecto, el reporte no está resuelto
        reportes.add(reporte);
        messagingTemplate.convertAndSend("/topic/reportes", reporte);
        return reporte;
    }

    // Marcar un reporte como resuelto
    @PutMapping("/{id}/resolver")
    public Reporte resolverReporte(@PathVariable Long id) {
        for (Reporte reporte : reportes) {
            if (reporte.getId().equals(id)) {
                reporte.setResuelto(true);
                return reporte;
            }
        }
        return null;
    }

    // Eliminar un reporte por ID
    @DeleteMapping("/{id}")
    public String eliminarReporte(@PathVariable Long id) {
        boolean eliminado = reportes.removeIf(reporte -> reporte.getId().equals(id));
        return eliminado ? "Reporte eliminado" : "Reporte no encontrado";
    }
    
   @PostMapping("/inconsistencias")
    public String reportarInconsistencia(@RequestBody Reporte reporte) {
        // Lógica para manejar el reporte
        return "Inconsistencia reportada con éxito.";
    }
}

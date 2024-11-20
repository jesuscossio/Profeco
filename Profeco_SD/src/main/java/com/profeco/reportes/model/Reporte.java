/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.reportes.model;

import java.time.LocalDateTime;
/**
 *
 * @author Jesus
 */
public class Reporte {
    private Long id; // Identificador único del reporte
    private Long idUsuario; // ID del usuario que creó el reporte
    private Long idProducto; // ID del producto relacionado
    private String descripcion; // Descripción del problema reportado
    private LocalDateTime fechaHora; // Fecha y hora en que se creó el reporte
    private Boolean resuelto; // Estado del reporte (resuelto o no)

    public Reporte() {
        // Constructor vacío para frameworks como Jackson
    }

    public Reporte(Long id, Long idUsuario, Long idProducto, String descripcion, LocalDateTime fechaHora, Boolean resuelto) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.resuelto = resuelto;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getResuelto() {
        return resuelto;
    }

    public void setResuelto(Boolean resuelto) {
        this.resuelto = resuelto;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idProducto=" + idProducto +
                ", descripcion='" + descripcion + '\'' +
                ", fechaHora=" + fechaHora +
                ", resuelto=" + resuelto +
                '}';
    }
}

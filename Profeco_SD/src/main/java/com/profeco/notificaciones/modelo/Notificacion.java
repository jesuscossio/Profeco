/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.notificaciones.modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Jesus
 */
public class Notificacion {
     private Long id; // Identificador único de la notificación
    private Long idUsuario; // ID del usuario destinatario
    private String mensaje; // Contenido de la notificación
    private LocalDateTime fechaHora; // Fecha y hora de la notificación
    private Boolean leida; // Estado de la notificación (leída o no)

    public Notificacion() {
        // Constructor vacío para frameworks como Jackson
    }

    public Notificacion(Long id, Long idUsuario, String mensaje, LocalDateTime fechaHora, Boolean leida) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.leida = leida;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getLeida() {
        return leida;
    }

    public void setLeida(Boolean leida) {
        this.leida = leida;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", mensaje='" + mensaje + '\'' +
                ", fechaHora=" + fechaHora +
                ", leida=" + leida +
                '}';
    }
}

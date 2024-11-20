/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profeco.notificaciones.controlador;
import com.profeco.notificaciones.modelo.Notificacion;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.time.LocalDateTime;

@Controller
/**
 *
 * @author Jesus
 */
public class WebSocketControlador {
    @MessageMapping("/enviarNotificacion") // Ruta donde los clientes envían mensajes
    @SendTo("/topic/notificaciones") // Canal al que se suscriben los clientes
    public Notificacion enviarNotificacion(Notificacion notificacion) {
        notificacion.setFechaHora(LocalDateTime.now());
        notificacion.setLeida(false); // Marcar como no leída inicialmente
        return notificacion; // Enviar la notificación a los suscriptores
    }
}

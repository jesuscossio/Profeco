/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.profeco.precios.modelo.Precio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jesus
 */
public class PrecioControlador {
      @GetMapping("/{productoId}")
    public Precio obtenerPrecio(@PathVariable Long productoId) {
        // Simulación de consulta de precio
        return new Precio(productoId, 99.99);
    }
}

package co.edu.uniquindio.poo.cafeteria.controller;

import co.edu.uniquindio.poo.cafeteria.model.DescuentoCantidad;
import java.util.Collection;

/**
 * Controller encargado de gestionar los niveles de descuento por cantidad.
 */
public class DescuentoController {

    private final DescuentoCantidad descuentoCantidad;

    public DescuentoController() {
        this.descuentoCantidad = new DescuentoCantidad();
    }

    /**
     * Obtiene todos los niveles de descuento.
     * @return Colección de niveles de descuento
     */


    /**
     * Agrega un nuevo nivel de descuento.
     * @param cantidadMinima Cantidad mínima requerida
     * @param porcentaje Porcentaje de descuento (0 a 1)
     */
    public void agregarDescuento(int cantidadMinima, double porcentaje) {
        descuentoCantidad.agregarNivelDescuento(cantidadMinima, porcentaje, "Descuento Personalizado");
    }

    /**
     * Elimina un nivel de descuento.
     * @param nivel Nivel de descuento a eliminar
     */

    /**
     * Obtiene la instancia de DescuentoCantidad para configuraciones adicionales.
     * @return DescuentoCantidad
     */
    public DescuentoCantidad getDescuentoCantidad() {
        return descuentoCantidad;
    }
}

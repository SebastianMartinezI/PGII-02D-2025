package co.edu.uniquindio.poo.cafeteria.controller;

import co.edu.uniquindio.poo.cafeteria.model.Recomendacion;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Controller encargado de gestionar las recomendaciones de la cafetería.
 */
public class RecomendacionController {

    private final Collection<Recomendacion> recomendaciones;

    public RecomendacionController() {
        this.recomendaciones = new LinkedList<>();
    }

    /**
     * Obtiene todas las recomendaciones.
     * @return Colección de recomendaciones
     */
    public Collection<Recomendacion> obtenerRecomendaciones() {
        return recomendaciones;
    }

    /**
     * Agrega una nueva recomendación.
     * @param mensaje Texto de la recomendación
     */
    public void agregarRecomendacion(String mensaje) {
        if(mensaje != null && !mensaje.isBlank()) {
            Recomendacion rec = new Recomendacion(mensaje);
            recomendaciones.add(rec);
        }
    }

    /**
     * Elimina una recomendación.
     * @param recomendacion Recomendación a eliminar
     */
    public void eliminarRecomendacion(Recomendacion recomendacion) {
        recomendaciones.remove(recomendacion);
    }
}

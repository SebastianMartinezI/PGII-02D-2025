package co.edu.uniquindio.poo.cafeteria.model;

import java.util.List;

public interface EstrategiaRecomendacion {
    /**
     * Genera una lista de productos recomendados según el cliente y los productos disponibles.
     *
     * @param cliente cliente al cual se le van a recomendar productos
     * @param productosDisponibles lista de productos de la cafetería
     * @return lista de productos recomendados
     */
    List<Producto> generarRecomendaciones(Cliente cliente, List<Producto> productosDisponibles);

    /**
     * Obtiene el nombre de la estrategia.
     * @return nombre de la estrategia
     */
    String getNombreEstrategia();

    /**
     * Obtiene la prioridad de la estrategia (un valor más alto significa mayor prioridad).
     * @return prioridad
     */
    int getPrioridad();
}


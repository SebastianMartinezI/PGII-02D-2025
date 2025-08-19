package co.edu.uniquindio.poo.cafeteria.model;

import java.util.List;

public interface EstrategiaRecomendacion {

    /**
     * Genera una recomendación personalizada según la estrategia aplicada.
     *
     * @param cliente   el cliente al que se le hará la recomendación
     * @param productos lista de productos disponibles
     * @return true si se generó una recomendación, false en caso contrario
     */
    boolean generarRecomendacion(Cliente cliente, List<Producto> productos);

    /**
     * Devuelve la recomendación generada por la estrategia.
     *
     * @return recomendación como texto
     */
    String getRecomendacion();
}


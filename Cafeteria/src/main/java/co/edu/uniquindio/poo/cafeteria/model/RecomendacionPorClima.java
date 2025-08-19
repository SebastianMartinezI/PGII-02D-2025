package co.edu.uniquindio.poo.cafeteria.model;

import java.util.List;

public class RecomendacionPorClima implements EstrategiaRecomendacion {

    private String recomendacion;

    @Override
    public boolean generarRecomendacion(Cliente cliente, List<Producto> productos) {
        // Ejemplo simple: recomendar paraguas si está lloviendo
        boolean lloviendo = true; // Supongamos que obtenemos esta info de una API externa
        if (lloviendo) {
            recomendacion = "Te recomendamos llevar un paraguas.";
            return true;
        }
        recomendacion = "Hoy el clima es agradable, disfruta lo que más te guste.";
        return true;
    }

    @Override
    public String getRecomendacion() {
        return recomendacion;
    }
}

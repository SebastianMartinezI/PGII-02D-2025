package co.edu.uniquindio.poo.cafeteria.model;

import java.util.List;

public class RecomendacionPorTendencia implements EstrategiaRecomendacion {

    private String recomendacion;

    @Override
    public boolean generarRecomendacion(Cliente cliente, List<Producto> productos) {
        // Ejemplo: recomendar productos en tendencia
        if (!productos.isEmpty()) {
            Producto masVendido = productos.get(0); // Supongamos que ya está ordenado por ventas
            recomendacion = "El producto en tendencia es: " + masVendido.getNombre() + ". ¡No te lo pierdas!";
            return true;
        }
        recomendacion = "No hay productos en tendencia por el momento.";
        return false;
    }

    @Override
    public String getRecomendacion() {
        return recomendacion;
    }
}

package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class RecomendacionPorTendencia implements EstrategiaRecomendacion {

    @Override
    public List<Producto> generarRecomendaciones(Cliente cliente, List<Producto> productosDisponibles) {
        List<Producto> recomendados = new ArrayList<>();

        if (!productosDisponibles.isEmpty()) {
            // Supongamos que productosDisponibles ya está ordenada por ventas descendentes
            Producto masVendido = productosDisponibles.get(0);
            recomendados.add(masVendido);
        }

        return recomendados;
    }

    @Override
    public String getNombreEstrategia() {
        return "Recomendación por tendencia";
    }

    @Override
    public int getPrioridad() {
        return 2; // Prioridad media
    }
}

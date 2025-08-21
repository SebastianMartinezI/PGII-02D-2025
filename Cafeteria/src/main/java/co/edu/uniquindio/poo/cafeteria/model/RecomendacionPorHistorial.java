package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class RecomendacionPorHistorial implements EstrategiaRecomendacion {

    @Override
    public List<Producto> generarRecomendaciones(Cliente cliente, List<Producto> productosDisponibles) {
        List<Producto> recomendados = new ArrayList<>();

        for (Producto historial : cliente.getHistorialCompras()) {
            for (Producto disponible : productosDisponibles) {
                if (disponible.getCategoria().equals(historial.getCategoria()) && !recomendados.contains(disponible)) {
                    recomendados.add(disponible);
                }
            }
        }

        return recomendados;
    }

    @Override
    public String getNombreEstrategia() {
        return "Recomendación por historial";
    }

    @Override
    public int getPrioridad() {
        return 5; // más alto, porque es personalizado
    }
}

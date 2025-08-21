package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class RecomendacionPorClima implements EstrategiaRecomendacion {

    private String clima; // "frio", "calido", etc.

    public RecomendacionPorClima(String clima) {
        this.clima = clima;
    }

    @Override
    public List<Producto> generarRecomendaciones(Cliente cliente, List<Producto> productosDisponibles) {
        List<Producto> recomendados = new ArrayList<>();

        for (Producto p : productosDisponibles) {
            if (clima.equalsIgnoreCase("frio") && p.getNombre().toLowerCase().contains("café")) {
                recomendados.add(p);
            } else if (clima.equalsIgnoreCase("calido") && p.getNombre().toLowerCase().contains("jugo")) {
                recomendados.add(p);
            }
        }

        return recomendados;
    }

    @Override
    public String getNombreEstrategia() {
        return "Recomendación por clima";
    }

    @Override
    public int getPrioridad() {
        return 3; // más prioridad que tendencia
    }
}

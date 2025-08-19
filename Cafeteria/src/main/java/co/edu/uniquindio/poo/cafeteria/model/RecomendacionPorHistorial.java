package co.edu.uniquindio.poo.cafeteria.model;

import java.util.List;

public class RecomendacionPorHistorial implements EstrategiaRecomendacion {

    private String recomendacion;

    @Override
    public boolean generarRecomendacion(Cliente cliente, List<Producto> productos) {
        // Ejemplo: recomendar en base a compras anteriores
        if (cliente.getHistorialPedidos().contains("Café")) {
            recomendacion = "Como disfrutas del café, prueba nuestra nueva línea de cafés especiales.";
            return true;
        }
        recomendacion = "Explora nuestros productos más populares para ti.";
        return true;
    }

    @Override
    public String getRecomendacion() {
        return recomendacion;
    }
}

package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class ServicioRecomendaciones {
    private List<EstrategiaRecomendacion> estrategias;
    private ServicioProductos servicioProductos;

    public ServicioRecomendaciones(List<EstrategiaRecomendacion> estrategias, ServicioProductos servicioProductos) {
        this.estrategias = new ArrayList<>();
        this.servicioProductos = servicioProductos;
    }

    public List<EstrategiaRecomendacion> getEstrategias() {
        return estrategias;
    }

    public void setEstrategias(List<EstrategiaRecomendacion> estrategias) {
        this.estrategias = estrategias;
    }

    public ServicioProductos getServicioProductos() {
        return servicioProductos;
    }

    public void setServicioProductos(ServicioProductos servicioProductos) {
        this.servicioProductos = servicioProductos;
    }

    @Override
    public String toString() {
        return "ServicioRecomendaciones{" +
                "estrategias=" + estrategias +
                ", servicioProductos=" + servicioProductos +
                '}';
    }
}

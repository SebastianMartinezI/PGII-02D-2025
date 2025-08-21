package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar las recomendaciones de productos
 * utilizando diferentes estrategias definidas por {@link EstrategiaRecomendacion}.
 */
public class ServicioRecomendaciones {

    private List<EstrategiaRecomendacion> estrategias;
    private ServicioProductos servicioProductos;

    /**
     * Constructor de la clase ServicioRecomendaciones.
     *
     * @param estrategias Lista de estrategias de recomendación a aplicar.
     * @param servicioProductos Servicio que gestiona los productos disponibles.
     */
    public ServicioRecomendaciones(List<EstrategiaRecomendacion> estrategias, ServicioProductos servicioProductos) {
        this.estrategias = (estrategias != null) ? estrategias : new ArrayList<>();
        this.servicioProductos = servicioProductos;
    }

    public List<EstrategiaRecomendacion> getEstrategias() {
        return estrategias;
    }

    public void setEstrategias(List<EstrategiaRecomendacion> estrategias) {
        this.estrategias = (estrategias != null) ? estrategias : new ArrayList<>();
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
                "estrategias=" + estrategias.size() + " estrategias" +
                ", servicioProductos=" + servicioProductos +
                '}';
    }
}

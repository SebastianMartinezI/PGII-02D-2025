package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class ServicioProductos {
    private List<Producto> productos;
    public ServicioProductos(List<Producto> productos) {
        this.productos = new ArrayList<>();
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "ServicioProductos{" +
                "productos=" + productos +
                '}';
    }
}

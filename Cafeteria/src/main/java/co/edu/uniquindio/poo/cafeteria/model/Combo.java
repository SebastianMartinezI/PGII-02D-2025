package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Producto {
    private List<Producto> productos;
    double porcentajeDescuento;

    public Combo(int id, String nombre, double precio, String descripcion,boolean disponible, List productos  ,double porcentajeDescuento) {
        super(id, nombre, precio, descripcion, disponible);
        this.productos = new ArrayList<>();
        this.porcentajeDescuento = porcentajeDescuento;

    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "productos=" + productos +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }
}

package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Producto {
    private List<Producto> productos;
    private double porcentajeDescuento;

    public Combo(int id, String nombre, String descripcion, boolean disponible,
                 List<Producto> productos, double porcentajeDescuento) {
        super(id, nombre, 0.0, descripcion, disponible); // El precio se calcula
        this.productos = new ArrayList<>(productos);
        this.porcentajeDescuento = porcentajeDescuento;
        this.precio = calcularPrecio(); // actualiza el precio del combo
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = new ArrayList<>(productos);
        this.precio = calcularPrecio(); // recalcular precio cuando cambian productos
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
        this.precio = calcularPrecio(); // recalcular precio cuando cambia el descuento
    }

    private double calcularPrecio() {
        double total = 0.0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total * (1 - porcentajeDescuento / 100);
    }

    @Override
    public String toString() {
        StringBuilder nombresProductos = new StringBuilder();
        for (Producto p : productos) {
            nombresProductos.append(p.getNombre()).append(", ");
        }
        if (!productos.isEmpty()) {
            nombresProductos.setLength(nombresProductos.length() - 2); // quitar última coma
        }

        return String.format(
                "Combo [ID=%d, Nombre='%s', Precio=%.2f, Descuento=%.1f%%, Productos=[%s]]",
                id, nombre, precio, porcentajeDescuento, nombresProductos.toString()
        );
    }
}

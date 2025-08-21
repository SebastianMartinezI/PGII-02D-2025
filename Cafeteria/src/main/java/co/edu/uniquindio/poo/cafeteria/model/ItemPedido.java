package co.edu.uniquindio.poo.cafeteria.model;

public class ItemPedido {
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;

    public ItemPedido(String nombreProducto, int cantidad, double precioUnitario) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}

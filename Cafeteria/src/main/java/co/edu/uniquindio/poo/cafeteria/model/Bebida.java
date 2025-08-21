package co.edu.uniquindio.poo.cafeteria.model;

public class Bebida extends Producto {
    private String tamaño;
    private boolean caliente;

    public Bebida(int id, String nombre, double precio, String descripcion,boolean disponible ,String tamaño, boolean caliente) {
        super(id, nombre, precio, descripcion, disponible);
        this.tamaño = tamaño;
        this.caliente = caliente;
    }

    public String getTamaño() { return tamaño; }
    public boolean isCaliente() { return caliente; }

    @Override
    public String toString() {
        return String.format(
                "Bebida [Nombre='%s', Precio=%.2f, Tamaño='%s', Tipo='%s']",
                 id, nombre, precio, tamaño, caliente ? "Caliente" : "Fría"
        );
    }

}

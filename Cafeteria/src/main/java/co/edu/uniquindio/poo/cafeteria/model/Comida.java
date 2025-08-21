package co.edu.uniquindio.poo.cafeteria.model;

public class Comida extends Producto {
    private String categoria;
    private int tiempoPreparacion; // en minutos

    /**
     * Constructor de la clase Comida
     *
     * @param id                Identificador único del producto
     * @param nombre            Nombre de la comida
     * @param precio            Precio de la comida
     * @param descripcion       Breve descripción del plato
     * @param disponible        Indica si está disponible para la venta
     * @param categoria         Categoría de la comida (ejemplo: "rápida", "vegetariana")
     * @param tiempoPreparacion Tiempo de preparación en minutos (debe ser positivo)
     */
    public Comida(int id, String nombre, double precio, String descripcion,
                  boolean disponible, String categoria, int tiempoPreparacion) {
        super(id, nombre, precio, descripcion, disponible);
        if (tiempoPreparacion < 0) {
            throw new IllegalArgumentException("El tiempo de preparación no puede ser negativo");
        }
        this.categoria = categoria;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        if (tiempoPreparacion < 0) {
            throw new IllegalArgumentException("El tiempo de preparación no puede ser negativo");
        }
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public String toString() {
        return String.format(
                "Comida{id=%d, nombre='%s', precio=%.2f, descripcion='%s', disponible=%s, categoria='%s', tiempoPreparacion=%d min}",
                getId(), getNombre(), getPrecio(), getDescripcion(), isDisponible(), categoria, tiempoPreparacion
        );
    }
}

package co.edu.uniquindio.poo.cafeteria.model;

/**
 * Clase abstracta que representa un producto genérico de la cafetería.
 * Contiene atributos comunes como id, nombre, precio, descripción y disponibilidad.
 * El id se genera automáticamente mediante un contador interno.
 */
public abstract class Producto {
    private final int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private boolean disponible;

    // Contador para autogenerar IDs únicos
    private static int contadorId = 1;

    /**
     * Constructor de la clase Producto.
     *
     * @param nombre      Nombre del producto (no puede estar vacío)
     * @param precio      Precio del producto (debe ser mayor o igual a 0)
     * @param descripcion Descripción breve del producto
     */
    public Producto(String nombre, double precio, String descripcion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.id = contadorId++;
        this.nombre = nombre.trim();
        this.precio = precio;
        this.descripcion = descripcion != null ? descripcion.trim() : "";
        this.disponible = true;
    }

    // ================== Getters ==================
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getDescripcion() { return descripcion; }
    public boolean isDisponible() { return disponible; }

    // ================== Setters ==================
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion != null ? descripcion.trim() : "";
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // ================== Métodos ==================
    @Override
    public String toString() {
        return String.format(
                "Producto[id=%d, nombre='%s', precio=%.2f, disponible=%s, descripcion='%s']",
                id, nombre, precio, disponible, descripcion
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Producto producto)) return false;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

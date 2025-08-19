package co.edu.uniquindio.poo.cafeteria.model;

public class Comida extends Producto {
    private String categoria;
    private int tiempoPreparacion;

    public Comida(int id, String nombre,double precio,String descripcion, boolean disponible, String categoria, int tiempoPreparacion) {
        super(id, nombre, precio, descripcion, disponible);
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
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "categoria='" + categoria + '\'' +
                ", tiempoPreparacion=" + tiempoPreparacion +
                '}';
    }
}

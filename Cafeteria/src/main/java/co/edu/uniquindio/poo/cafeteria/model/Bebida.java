package co.edu.uniquindio.poo.cafeteria.model;

public class Bebida extends Producto {
    private String tamanio;

    public Bebida(int id, String nombre, double precio,String descripcion,boolean disponible, String tamanio) {
        super(id,nombre,precio,descripcion,disponible);
        this.tamanio = tamanio;

    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "tamanio='" + tamanio + '\'' +
                '}';
    }
}

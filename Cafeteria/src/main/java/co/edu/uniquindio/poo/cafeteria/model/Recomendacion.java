package co.edu.uniquindio.poo.cafeteria.model;

/**
 * Clase que representa una recomendación de la cafetería
 */
public class Recomendacion {

    private String mensaje;

    public Recomendacion(String mensaje) {
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return mensaje;
    }
}

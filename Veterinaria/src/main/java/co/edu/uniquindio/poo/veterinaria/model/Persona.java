package co.edu.uniquindio.poo.veterinaria.model;

import java.util.List;

public class Persona {
    private String nombre;
    private String identificacion;
    private String telefono;
    private String direccion;

    /**
     * Construye un nuevo objeto Persona con la información básica.
     *
     * @param nombre nombre completo de la persona
     * @param identificacion número de identificación de la persona
     * @param telefono número de teléfono de contacto
     * @param direccion dirección de residencia
     */
    public Persona(String nombre, String identificacion, String telefono, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Retorna una representación en cadena del objeto Persona,
     * mostrando sus datos principales como nombre, identificación,
     * teléfono y dirección.
     *
     * @return una cadena con la información de la persona
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", identificacion=" + identificacion +
                ", telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
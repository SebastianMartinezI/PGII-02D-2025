package co.edu.uniquindio.poo.veterinaria.model;

public class Propietario extends Persona {

    /**
     * Construye un nuevo objeto Propietario con la información básica.
     *
     * @param nombre nombre completo del propietario
     * @param identificacion número de identificación del propietario
     * @param telefono número de teléfono de contacto del propietario
     * @param direccion dirección de residencia del propietario
     */
    public Propietario(String nombre, String identificacion, String telefono, String direccion) {
        super(nombre, identificacion, telefono, direccion);
    }
}
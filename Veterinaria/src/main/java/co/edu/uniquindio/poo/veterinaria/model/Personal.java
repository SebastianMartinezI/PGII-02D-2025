package co.edu.uniquindio.poo.veterinaria.model;

public class Personal extends Persona {

    private String profesion;

    public Personal(String nombre, String identificacion, String telefono, String direccion,String profesion) {
        super(nombre, identificacion, telefono, direccion);
        this.profesion = profesion;
    }
}


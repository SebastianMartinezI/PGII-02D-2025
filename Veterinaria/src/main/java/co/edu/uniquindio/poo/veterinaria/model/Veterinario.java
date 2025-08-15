package co.edu.uniquindio.poo.veterinaria.model;

public class Veterinario extends Persona {
    private String licenciaProfesional;
    private String especialidad;


    public Veterinario(String nombre, String identificacion, String telefono, String direccion, String licenciaProfesional, String especialidad) {
        super(nombre, identificacion,telefono, direccion);
        this.licenciaProfesional = licenciaProfesional;
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLicenciaProfesional() {
        return licenciaProfesional;
    }

    public void setLicenciaProfesional(String licenciaProfesional) {
        this.licenciaProfesional = licenciaProfesional;
    }

}

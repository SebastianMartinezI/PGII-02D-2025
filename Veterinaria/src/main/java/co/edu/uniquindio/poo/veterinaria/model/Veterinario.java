package co.edu.uniquindio.poo.veterinaria.model;

public class Veterinario extends Persona {
    private String licenciaProfesional;
    private String especialidad;

    /**
     * Constructor de la clase Veterinario.
     *
     * @param nombre               Nombre del veterinario.
     * @param identificacion       Identificación del veterinario.
     * @param telefono             Número de teléfono de contacto.
     * @param direccion            Dirección de residencia o trabajo.
     * @param licenciaProfesional  Número de licencia profesional.
     * @param especialidad         Especialidad del veterinario.
     */
    public Veterinario(String nombre, String identificacion, String telefono, String direccion, String licenciaProfesional, String especialidad) {
        super(nombre, identificacion, telefono, direccion);
        this.licenciaProfesional = licenciaProfesional;
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la especialidad del veterinario.
     *
     * @return especialidad del veterinario.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Asigna una nueva especialidad al veterinario.
     *
     * @param especialidad Nueva especialidad.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la licencia profesional del veterinario.
     *
     * @return licencia profesional del veterinario.
     */
    public String getLicenciaProfesional() {
        return licenciaProfesional;
    }

    /**
     * Asigna una nueva licencia profesional al veterinario.
     *
     * @param licenciaProfesional Nueva licencia profesional.
     */
    public void setLicenciaProfesional(String licenciaProfesional) {
        this.licenciaProfesional = licenciaProfesional;
    }
}

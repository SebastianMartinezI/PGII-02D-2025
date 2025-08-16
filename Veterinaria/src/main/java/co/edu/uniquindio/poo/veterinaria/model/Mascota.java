package co.edu.uniquindio.poo.veterinaria.model;

public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private String edad;
    private String identificacionVeterinaria;
    private String propietario;

    /**
     * Construye un nuevo objeto Mascota con los datos básicos.
     *
     * @param nombre nombre de la mascota
     * @param especie especie a la que pertenece la mascota (ejemplo: perro, gato, etc.)
     * @param raza raza de la mascota
     * @param edad edad de la mascota
     * @param identificacionVeterinaria código o identificación única de la mascota
     * @param propietario nombre del propietario de la mascota
     */
    public Mascota(String nombre, String especie, String raza, String edad, String identificacionVeterinaria, String propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.identificacionVeterinaria = identificacionVeterinaria;
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getIdentificacionVeterinaria() {
        return identificacionVeterinaria;
    }
    public void setIdentificacionVeterinaria(String identificacionVeterinaria) {
        this.identificacionVeterinaria = identificacionVeterinaria;
    }

    /**
     * Retorna una representación en cadena del objeto Mascota,
     * mostrando sus datos principales como nombre, propietario,
     * identificación veterinaria, edad, especie y raza.
     *
     * @return una cadena con la información resumida de la mascota
     */
    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", propietario=" + propietario +
                ", identificacionVeterinaria=" + identificacionVeterinaria +
                ", edad=" + edad +
                ", especie=" + especie +
                ", raza='" + raza + '\'' +
                '}';
    }
}

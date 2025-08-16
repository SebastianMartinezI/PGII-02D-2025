package co.edu.uniquindio.poo.veterinaria.model;

public class Cita {
    private int idCita;
    private String fechaCita;
    private String nombreCita;

    /**
     * Construye una nueva cita con los datos especificados.
     *
     * @param idCita     identificador único de la cita
     * @param fechaCita  fecha en la que se realizará la cita
     * @param nombreCita nombre o motivo de la cita
     */
    public Cita(int idCita, String fechaCita, String nombreCita) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.nombreCita = nombreCita;
    }
}
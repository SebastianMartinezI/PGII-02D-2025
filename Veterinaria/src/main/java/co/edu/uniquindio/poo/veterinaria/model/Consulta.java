package co.edu.uniquindio.poo.veterinaria.model;

public class Consulta {
    private String fecha;
    private String hora;
    private String mascota;
    private String veterinario;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;

    /**
     * Construye una nueva consulta con los datos especificados.
     *
     * @param fecha          fecha en la que se realiza la consulta
     * @param hora           hora en la que se realiza la consulta
     * @param mascota        nombre o identificación de la mascota atendida
     * @param veterinario    nombre del veterinario que atiende la consulta
     * @param motivoConsulta motivo por el cual se realiza la consulta
     * @param diagnostico    diagnóstico realizado por el veterinario
     * @param tratamiento    tratamiento recomendado para la mascota
     */
    public Consulta(String fecha, String hora, String mascota, String veterinario,
                    String motivoConsulta, String diagnostico, String tratamiento) {
        this.fecha = fecha;
        this.hora = hora;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMascota() {
        return mascota;
    }
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    /**
     * Retorna una representación en cadena del objeto Consulta,
     * mostrando sus principales atributos excepto el tratamiento.
     *
     * @return una cadena de texto con los datos de la consulta
     */
    @Override
    public String toString() {
        return "Consulta{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", mascota=" + mascota +
                ", veterinario=" + veterinario +
                ", motivoConsulta='" + motivoConsulta + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                // ", tratamiento=" + tratamiento +
                '}';
    }
}
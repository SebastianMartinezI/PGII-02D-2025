package co.edu.uniquindio.poo.veterinaria.model;

public class Consulta {
    private String fecha;
    private String hora;
    private String mascota;
    private String veterinario;
    private String motivoConsulta;
    private String diagnostico;
    // private String tratamiento;

    public Consulta(String fecha, String hora, String mascota, String veterinario, String motivoConsulta, String diagnostico) {
        this.fecha = fecha;
        this.hora = hora;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        // this.tratamiento = tratamiento;

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

    //public String getTratamiento() {
    //  return tratamiento;
    //}

    //public void setTratamiento(String tratamiento) {
    // this.tratamiento = tratamiento;
    //}

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
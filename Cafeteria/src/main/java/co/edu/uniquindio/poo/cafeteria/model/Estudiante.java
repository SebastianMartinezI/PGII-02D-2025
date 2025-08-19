package co.edu.uniquindio.poo.cafeteria.model;

import java.time.LocalDate;

public class Estudiante extends Cliente {
    private String codigoEstudiante;

    public Estudiante(int idCliente, String nombre, String email, LocalDate fechaRegistro, String codigoEstudiante) {
        super(idCliente, nombre, email, fechaRegistro);
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigoEstudiante='" + codigoEstudiante + '\'' +
                ", datosCliente=" + super.toString() +
                '}';
    }
}


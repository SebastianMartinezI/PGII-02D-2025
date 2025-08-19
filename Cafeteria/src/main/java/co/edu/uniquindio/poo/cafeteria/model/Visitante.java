package co.edu.uniquindio.poo.cafeteria.model;

import java.time.LocalDate;

public class Visitante extends Cliente {
    private String documentoIdentidad;

    public Visitante(int idCliente, String nombre, String email, LocalDate fechaRegistro, String documentoIdentidad) {
        super(idCliente, nombre, email, fechaRegistro);
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "documentoIdentidad='" + documentoIdentidad + '\'' +
                ", datosCliente=" + super.toString() +
                '}';
    }
}


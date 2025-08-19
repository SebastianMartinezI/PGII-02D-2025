package co.edu.uniquindio.poo.cafeteria.model;

import java.time.LocalDate;

public class Docente extends Cliente {
    private String codigoEmpleado;

    public Docente(int idCliente, String nombre, String email, LocalDate fechaRegistro, String codigoEmpleado) {
        super(idCliente, nombre, email, fechaRegistro);
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", datosCliente=" + super.toString() +
                '}';
    }
}

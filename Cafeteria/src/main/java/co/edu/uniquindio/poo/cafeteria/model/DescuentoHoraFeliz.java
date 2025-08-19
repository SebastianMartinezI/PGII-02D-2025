package co.edu.uniquindio.poo.cafeteria.model;

import java.sql.Time;
import java.time.LocalTime;

public class DescuentoHoraFeliz implements EstrategiaDescuento {
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public DescuentoHoraFeliz(LocalTime horaInicio, LocalTime horaFin) {
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public double calcularDescuento(double total) {
        LocalTime ahora = LocalTime.now();

        // Verifica si la hora actual está dentro del rango
        if (!ahora.isBefore(horaInicio) && !ahora.isAfter(horaFin)) {
            return total * 0.20; // 20% de descuento
        }

        return 0; // No hay descuento fuera de la hora feliz
    }


    @Override
    public String descripcionDescuento() {
        return "Descuento del 20% por Hora Feliz (entre " + horaInicio + " y " + horaFin + ")";
    }
}


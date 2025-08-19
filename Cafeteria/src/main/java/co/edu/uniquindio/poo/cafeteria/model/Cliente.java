package co.edu.uniquindio.poo.cafeteria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String email;
    private LocalDate fechaRegistro;
    private List<Pedido> historialPedidos;

    public Cliente(int idCliente, String nombre, String email, LocalDate fechaRegistro) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.historialPedidos = new ArrayList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public List<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void agregarPedido(Pedido pedido) {
        this.historialPedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", historialPedidos=" + historialPedidos +
                '}';
    }
}

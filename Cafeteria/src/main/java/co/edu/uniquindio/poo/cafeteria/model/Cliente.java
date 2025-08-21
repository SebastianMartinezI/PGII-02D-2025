package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Clase abstracta que representa un cliente de la cafetería.
 * Define las características comunes de todos los tipos de clientes.
 */
public abstract class Cliente {
    private final int idCliente;
    private final Date fechaRegistro;
    private String nombre;
    private String email;
    private final List<Pedido> historialPedidos;
    private static int contadorId = 1;

    /**
     * Constructor base para crear un cliente
     * @param nombre Nombre completo del cliente
     * @param email Correo electrónico del cliente
     */
    public Cliente(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (email == null || !validarEmail(email)) {
            throw new IllegalArgumentException("El email debe tener un formato válido");
        }

        this.idCliente = contadorId++;
        this.nombre = nombre.trim();
        this.email = email.toLowerCase().trim();
        this.fechaRegistro = new Date();
        this.historialPedidos = new ArrayList<>();
    }

    // ================== Getters y Setters ==================
    public int getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !validarEmail(email)) {
            throw new IllegalArgumentException("El email debe tener un formato válido");
        }
        this.email = email.toLowerCase().trim();
    }

    public Date getFechaRegistro() { return new Date(fechaRegistro.getTime()); }

    public List<Pedido> getHistorialPedidos() {
        return new ArrayList<>(historialPedidos); // copia defensiva
    }

    // ================== Métodos ==================

    /**
     * Agrega un pedido al historial del cliente
     * @param pedido El pedido a agregar
     */
    public void agregarPedido(Pedido pedido) {
        if (pedido != null && pedido.getCliente().equals(this)) {
            historialPedidos.add(pedido);
        }
    }

    /**
     * Calcula el total gastado por el cliente en todos sus pedidos
     * @return Total gastado
     */
    public double calcularTotalGastado() {
        return historialPedidos.stream()
                .mapToDouble(Pedido::getTotal)
                .sum();
    }

    /**
     * Obtiene la cantidad total de pedidos realizados
     * @return Número de pedidos
     */
    public int getCantidadPedidos() {
        return historialPedidos.size();
    }

    /**
     * Verifica si el cliente es frecuente (más de 5 pedidos)
     * @return true si es cliente frecuente
     */
    public boolean esClienteFrecuente() {
        return historialPedidos.size() > 5;
    }

    // ================== Métodos abstractos ==================
    public abstract String getTipoCliente();
    public abstract double getTasaDescuentoBase();
    public abstract String getInformacionAdicional();

    // ================== Utilidades ==================
    private boolean validarEmail(String email) {
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente cliente)) return false;
        return idCliente == cliente.idCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    @Override
    public String toString() {
        return String.format("%s{id=%d, nombre='%s', email='%s', fechaRegistro=%tF, pedidos=%d, totalGastado=%.2f}",
                getTipoCliente(), idCliente, nombre, email, fechaRegistro,
                getCantidadPedidos(), calcularTotalGastado());
    }
}

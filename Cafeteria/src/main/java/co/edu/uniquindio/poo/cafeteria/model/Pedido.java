package co.edu.uniquindio.poo.cafeteria.model;

import java.util.Date;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private Date fechaPedido;
    private EstadoPedido estadoPedido;
    private double subTotal;
    private double descuentoTotal;
    private double total;

    public Pedido(int idPedido, Cliente cliente, Date fechaPedido, EstadoPedido estadoPedido, double descuentoTotal, double total) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.descuentoTotal = descuentoTotal;
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

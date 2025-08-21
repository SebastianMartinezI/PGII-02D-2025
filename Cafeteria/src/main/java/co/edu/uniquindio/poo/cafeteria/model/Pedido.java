package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private Date fechaPedido;
    private double subTotal;
    private double descuentoTotal;
    private double total;
    private List<ItemPedido> items; // Lista de ítems del pedido

    // Constructor
    public Pedido(int idPedido, Cliente cliente, Date fechaPedido) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.subTotal = 0.0;
        this.descuentoTotal = 0.0;
        this.total = 0.0;
        this.items = new ArrayList<>();
    }

    // Métodos para agregar y obtener ítems
    public void agregarItem(ItemPedido item) {
        if (item != null) {
            items.add(item);
        }
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    // Método para calcular el subtotal sumando los subtotales de cada item
    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (ItemPedido item : items) {
            subtotal += item.getSubtotal(); // cada ItemPedido debe tener getSubtotal()
        }
        this.subTotal = subtotal;
        return subtotal;
    }

    // Getters y setters
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Date getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(Date fechaPedido) { this.fechaPedido = fechaPedido; }

    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }

    public double getDescuentoTotal() { return descuentoTotal; }
    public void setDescuentoTotal(double descuentoTotal) { this.descuentoTotal = descuentoTotal; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "Sin cliente") +
                ", fechaPedido=" + fechaPedido +
                ", subTotal=" + subTotal +
                ", descuentoTotal=" + descuentoTotal +
                ", total=" + total +
                ", items=" + items.size() +
                '}';
    }
}


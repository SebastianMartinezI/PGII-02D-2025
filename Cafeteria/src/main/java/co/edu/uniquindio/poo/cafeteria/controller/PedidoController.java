package co.edu.uniquindio.poo.cafeteria.controller;

import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.Cliente;
import co.edu.uniquindio.poo.cafeteria.model.Pedido;
import co.edu.uniquindio.poo.cafeteria.model.Producto;

import java.util.Collection;

/**
 * Controller encargado de la gestión de pedidos.
 */
public class PedidoController {

    private final Cafeteria cafeteria;

    public PedidoController(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    /**
     * Crea un nuevo pedido para un cliente.
     * @param cliente Cliente que realiza el pedido
     * @return Pedido creado
     */
    public Pedido crearPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        cafeteria.agregarPedido(pedido);
        return pedido;
    }

    /**
     * Agrega un producto al pedido.
     * @param pedido Pedido a modificar
     * @param producto Producto a agregar
     * @param cantidad Cantidad del producto
     * @return true si se agregó correctamente
     */
    public boolean agregarProducto(Pedido pedido, Producto producto, int cantidad) {
        if(pedido != null && producto != null && cantidad > 0) {
            pedido.agregarProducto(producto, cantidad);
            pedido.calcularSubtotal(); // Actualiza subtotal y total
            return true;
        }
        return false;
    }

    /**
     * Elimina un pedido de la cafetería.
     * @param pedido Pedido a eliminar
     * @return true si se eliminó
     */
    public boolean eliminarPedido(Pedido pedido) {
        return cafeteria.eliminarPedido(pedido);
    }

    /**
     * Obtiene todos los pedidos registrados.
     * @return Colección de pedidos
     */
    public Collection<Pedido> obtenerPedidos() {
        return cafeteria.getPedidos();
    }

    /**
     * Calcula y actualiza el total del pedido considerando subtotal y descuentos.
     * @param pedido Pedido a procesar
     */
    public void procesarPedido(Pedido pedido) {
        if(pedido != null) {
            pedido.calcularSubtotal();
        }
    }
}

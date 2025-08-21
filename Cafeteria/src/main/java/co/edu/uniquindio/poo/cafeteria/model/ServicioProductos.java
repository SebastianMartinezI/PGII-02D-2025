package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los productos de la cafetería y los pedidos.
 */
public class ServicioProductos {

    private List<Producto> productos;
    private List<Pedido> pedidos;

    public ServicioProductos() {
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    // ----------------- Productos -----------------

    public void agregarProducto(Producto producto) {
        if (producto != null && !productos.contains(producto)) {
            productos.add(producto);
        }
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    public Producto buscarProductoPorNombre(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // ----------------- Pedidos -----------------

    public void agregarPedido(Pedido pedido) {
        if (pedido != null) {
            pedidos.add(pedido);
        }
    }

    public void eliminarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    public Pedido buscarPedidoPorId(int id) {
        return pedidos.stream()
                .filter(p -> p.getIdPedido() == id)
                .findFirst()
                .orElse(null);
    }

    // ----------------- Otros métodos -----------------

    /**
     * Calcular total de un pedido aplicando los descuentos correspondientes
     */
    public double calcularTotalPedido(Pedido pedido) {
        if (pedido == null) return 0.0;
        double subtotal = pedido.getSubTotal();

        // Aplicar descuentos según las estrategias configuradas
        double descuentoTotal = 0.0;
        if (pedido.getEstrategiaDescuento() != null) {
            descuentoTotal = pedido.getEstrategiaDescuento().calcularDescuento(pedido);
        }

        return subtotal - descuentoTotal;
    }
}

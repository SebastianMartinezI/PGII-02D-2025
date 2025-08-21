package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase central que gestiona la cafetería: clientes, productos, pedidos,
 * estrategias de recomendación y estrategias de descuento.
 */
public class Cafeteria {

    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Pedido> pedidos;

    private List<EstrategiaRecomendacion> estrategiasRecomendacion;
    private List<EstrategiaDescuento> estrategiasDescuento;

    public Cafeteria() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();

        estrategiasRecomendacion = new ArrayList<>();
        estrategiasDescuento = new ArrayList<>();
    }

    // ------------------- CLIENTES -------------------
    public boolean agregarCliente(Cliente cliente) {
        boolean agregado = false;
        if (cliente.getIdCliente() == (clientes.size() + 1)) {
            clientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }

    public boolean eliminarCliente(int idCliente) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == (idCliente)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // ------------------- PRODUCTOS -------------------
    public boolean agregarProducto(Producto producto) {
        boolean centinela = false;
        if (producto != null && !productos.contains(producto)) {
            productos.add(producto);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarProducto(String nombre) {
        boolean centinela = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                productos.remove(producto);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // ------------------- PEDIDOS -------------------
    public void agregarPedido(Pedido pedido) {
        if (pedido != null) {
            pedidos.add(pedido);
            // Agregar el pedido al historial del cliente
            pedido.getCliente().getHistorialPedidos().add(pedido);
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // ------------------- RECOMENDACIONES -------------------
    public void agregarEstrategiaRecomendacion(EstrategiaRecomendacion estrategia) {
        if (estrategia != null) {
            estrategiasRecomendacion.add(estrategia);
        }
    }

    public List<String> obtenerRecomendaciones(Cliente cliente) {
        List<String> recomendaciones = new ArrayList<>();
        for (EstrategiaRecomendacion estrategia : estrategiasRecomendacion) {
                recomendaciones.add(estrategia.getNombreEstrategia());
            }
        return recomendaciones;
    }

    // ------------------- DESCUENTOS -------------------
    public void agregarEstrategiaDescuento(EstrategiaDescuento estrategia) {
        if (estrategia != null) {
            estrategiasDescuento.add(estrategia);
        }
    }

    public double calcularDescuentoPedido(Pedido pedido) {
        double descuentoMaximo = 0;
        for (EstrategiaDescuento estrategia : estrategiasDescuento) {
            if (estrategia.esAplicable(pedido)) {
                double descuento = estrategia.calcularDescuento(pedido);
                if (descuento > descuentoMaximo) {
                    descuentoMaximo = descuento;
                }
            }
        }
        return descuentoMaximo;
    }

    // ------------------- UTILIDADES -------------------
    public Producto buscarProductoPorNombre(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public Cliente buscarClientePorNombre(String nombre) {
        return clientes.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public void mostrarInfoCafeteria() {
        System.out.println("=== CAFETERIA ===");
        System.out.println("Clientes registrados: " + clientes.size());
        System.out.println("Productos disponibles: " + productos.size());
        System.out.println("Pedidos realizados: " + pedidos.size());
    }
}

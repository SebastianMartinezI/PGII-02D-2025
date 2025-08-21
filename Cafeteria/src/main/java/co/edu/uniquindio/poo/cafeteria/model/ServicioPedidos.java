package co.edu.uniquindio.poo.cafeteria.model;

import co.edu.uniquindio.poo.cafeteria.model.Pedido;
import co.edu.uniquindio.poo.cafeteria.model.Producto;
import co.edu.uniquindio.poo.cafeteria.model.Cliente;
import co.edu.uniquindio.poo.cafeteria.model.EstrategiaDescuento;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar la lógica de creación, procesamiento
 * y administración de pedidos en la cafetería.
 */
public class ServicioPedidos {

    /** Lista de estrategias de descuento aplicables al pedido */
    private final List<EstrategiaDescuento> estrategiasDescuento;

    /** Tasa de impuesto (IVA) aplicada a los pedidos */
    private static final double TASA_IMPUESTO = 0.19; // 19% IVA

    /**
     * Constructor por defecto, inicializa la lista de estrategias.
     */
    public ServicioPedidos() {
        this.estrategiasDescuento = new ArrayList<>();
    }

    /**
     * Crea un nuevo pedido asociado a un cliente.
     *
     * @param cliente Cliente que realiza el pedido
     * @return Pedido creado
     */
    public Pedido crearPedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        return new Pedido(cliente);
    }

    /**
     * Agrega un ítem al pedido.
     *
     * @param pedido   Pedido en el que se agrega el ítem
     * @param producto Producto que se agrega
     * @param cantidad Cantidad del producto
     */
    public void agregarItemPedido(Pedido pedido, Producto producto, int cantidad) {
        if (pedido == null || producto == null) {
            throw new IllegalArgumentException("El pedido y el producto no pueden ser nulos");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (!producto.isDisponible()) {
            throw new IllegalStateException("El producto " + producto.getNombre() + " no está disponible");
        }

    }

    /**
     * Procesa el pedido: calcula subtotal, descuentos, impuestos y total.
     *
     * @param pedido Pedido a procesar
     * @return Total final del pedido
     */
    public double procesarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }

        // 1. Calcular subtotal
        double subtotal = pedido.calcularSubTotal();

        // 2. Aplicar descuentos
        double descuentoTotal = 0;
        for (EstrategiaDescuento estrategia : estrategiasDescuento) {
            descuentoTotal += estrategia.calcularDescuento(pedido);
        }

        // 3. Calcular impuestos sobre el subtotal con descuento
        double subtotalConDescuento = Math.max(0, subtotal - descuentoTotal); // aseguramos que no sea negativo
        double impuestos = subtotalConDescuento * TASA_IMPUESTO;

        // 4. Calcular total final
        double total = subtotalConDescuento + impuestos;

        // 5. Actualizar pedido con los valores calculados
        pedido.setSubTotal(subtotal);
        pedido.setDescuentoTotal(descuentoTotal);
        pedido.setTotal(total);

        return total;
    }

    /**
     * Agrega una estrategia de descuento a la lista.
     *
     * @param estrategia Estrategia a agregar
     */
    public void agregarEstrategiaDescuento(EstrategiaDescuento estrategia) {
        if (estrategia != null) {
            this.estrategiasDescuento.add(estrategia);
        }
    }

    /**
     * Retorna una copia inmutable de las estrategias de descuento.
     *
     * @return Lista de estrategias de descuento
     */
    public List<EstrategiaDescuento> getEstrategiasDescuento() {
        return new ArrayList<>(estrategiasDescuento);
    }

    @Override
    public String toString() {
        return "ServicioPedidos{" +
                "estrategiasDescuento=" + estrategiasDescuento.size() +
                ", tasaImpuesto=" + (TASA_IMPUESTO * 100) + "%" +
                '}';
    }
}

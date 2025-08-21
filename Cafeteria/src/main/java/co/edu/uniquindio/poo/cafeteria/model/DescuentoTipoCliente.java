package co.edu.uniquindio.poo.cafeteria.model;

import java.util.Map;

/**
 * Estrategia de descuento basada en el tipo de cliente.
 * Aplica diferentes tasas de descuento según si el cliente es
 * Estudiante, Docente o Visitante.
 */
public class DescuentoTipoCliente implements EstrategiaDescuento {

    private final Map<String, Double> tasasDescuento;

    /**
     * Constructor que inicializa las tasas de descuento por tipo de cliente.
     */
    public DescuentoTipoCliente() {
        tasasDescuento = Map.of(
                "Estudiante", 0.15, // 15% de descuento
                "Docente", 0.10,    // 10% de descuento
                "Visitante", 0.0    // Sin descuento
        );
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        String tipoCliente = pedido.getCliente().getTipoCliente();
        double tasaDescuento = tasasDescuento.getOrDefault(tipoCliente, 0.0);
        return pedido.getSubtotal() * tasaDescuento;
    }

    @Override
    public String getDescripcionDescuento() {
        return "Descuento aplicado según el tipo de cliente (Estudiante, Docente o Visitante).";
    }

    @Override
    public String getTipoDescuento() {
        return "DESCUENTO_TIPO_CLIENTE";
    }
}



package co.edu.uniquindio.poo.cafeteria.model;

/**
 * EstrategiaDescuento define el contrato para las diferentes estrategias
 * de cálculo de descuentos aplicables a los pedidos en la cafetería.
 */
public interface EstrategiaDescuento {

    /**
     * Calcula el valor del descuento aplicable a un pedido.
     *
     * @param pedido Pedido al cual se le aplicará el descuento
     * @return Monto del descuento a aplicar
     */
    double calcularDescuento(Pedido pedido);

    /**
     * Verifica si el descuento es aplicable al pedido dado.
     *
     * @param pedido Pedido a evaluar
     * @return true si aplica, false en caso contrario
     */
    default boolean esAplicable(Pedido pedido) {
        return pedido != null;
    }

    /**
     * Obtiene una descripción legible del descuento.
     *
     * @return Descripción del descuento
     */
    String getDescripcionDescuento();

    /**
     * Obtiene el tipo o nombre del descuento (por ejemplo: "Promoción", "Fidelidad", etc.).
     *
     * @return Tipo de descuento
     */
    String getTipoDescuento();
}


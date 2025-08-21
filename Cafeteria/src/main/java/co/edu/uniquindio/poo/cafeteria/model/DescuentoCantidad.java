package co.edu.uniquindio.poo.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de descuento basado en la cantidad de productos comprados.
 * Ofrece descuentos escalonados según diferentes niveles de cantidad.
 */
public class DescuentoCantidad implements EstrategiaDescuento {

    public static class NivelDescuento {
        private final int cantidadMinima;
        private final double porcentajeDescuento;
        private final String descripcion;

        public NivelDescuento(int cantidadMinima, double porcentajeDescuento, String descripcion) {
            if (cantidadMinima < 0) throw new IllegalArgumentException("La cantidad mínima no puede ser negativa");
            if (porcentajeDescuento < 0 || porcentajeDescuento > 1)
                throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 1");

            this.cantidadMinima = cantidadMinima;
            this.porcentajeDescuento = porcentajeDescuento;
            this.descripcion = descripcion != null ? descripcion : "Descuento por cantidad";
        }

        public int getCantidadMinima() { return cantidadMinima; }
        public double getPorcentajeDescuento() { return porcentajeDescuento; }
        public String getDescripcion() { return descripcion; }

        @Override
        public String toString() {
            return String.format("%s: %d+ items = %.0f%% descuento",
                    descripcion, cantidadMinima, porcentajeDescuento * 100);
        }
    }

    private List<NivelDescuento> nivelesDescuento;
    private boolean aplicarPorItem;

    public DescuentoCantidad() {
        this.nivelesDescuento = new ArrayList<>();
        this.aplicarPorItem = false;
        configurarNivelesPredeterminados();
    }

    public DescuentoCantidad(int cantidadMinima, double porcentajeDescuento) {
        this.nivelesDescuento = new ArrayList<>();
        this.aplicarPorItem = false;
        agregarNivelDescuento(cantidadMinima, porcentajeDescuento,
                String.format("Descuento %d+ items", cantidadMinima));
    }

    public DescuentoCantidad(int cantidadMinima, double porcentajeDescuento, boolean aplicarPorItem) {
        this(cantidadMinima, porcentajeDescuento);
        this.aplicarPorItem = aplicarPorItem;
    }

    private void configurarNivelesPredeterminados() {
        agregarNivelDescuento(5, 0.05, "Descuento Básico");
        agregarNivelDescuento(10, 0.10, "Descuento Intermedio");
        agregarNivelDescuento(15, 0.15, "Descuento Avanzado");
        agregarNivelDescuento(20, 0.20, "Descuento Mayorista");
    }

    public void agregarNivelDescuento(int cantidadMinima, double porcentajeDescuento, String descripcion) {
        NivelDescuento nivel = new NivelDescuento(cantidadMinima, porcentajeDescuento, descripcion);
        nivelesDescuento.add(nivel);
        nivelesDescuento.sort((a, b) -> Integer.compare(b.getCantidadMinima(), a.getCantidadMinima()));
    }

    public void setAplicarPorItem(boolean aplicarPorItem) {
        this.aplicarPorItem = aplicarPorItem;
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        if (!esAplicable(pedido)) return 0.0;
        return aplicarPorItem ? calcularDescuentoPorItem(pedido) : calcularDescuentoPorTotal(pedido);
    }

    private double calcularDescuentoPorItem(Pedido pedido) {
        double descuentoTotal = 0.0;
        for (ItemPedido item : pedido.getItems()) {
            NivelDescuento nivel = obtenerMejorNivel(item.getCantidad());
            if (nivel != null) descuentoTotal += item.getSubtotal() * nivel.getPorcentajeDescuento();
        }
        return descuentoTotal;
    }

    private double calcularDescuentoPorTotal(Pedido pedido) {
        int cantidadTotal = pedido.getItems().stream().mapToInt(ItemPedido::getCantidad).sum();
        NivelDescuento nivel = obtenerMejorNivel(cantidadTotal);
        return nivel != null ? pedido.getSubtotal() * nivel.getPorcentajeDescuento() : 0.0;
    }

    private NivelDescuento obtenerMejorNivel(int cantidad) {
        return nivelesDescuento.stream()
                .filter(n -> cantidad >= n.getCantidadMinima())
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean esAplicable(Pedido pedido) {
        if (pedido == null || pedido.getItems().isEmpty()) return false;
        if (aplicarPorItem) {
            return pedido.getItems().stream().anyMatch(item -> obtenerMejorNivel(item.getCantidad()) != null);
        } else {
            int total = pedido.getItems().stream().mapToInt(ItemPedido::getCantidad).sum();
            return obtenerMejorNivel(total) != null;
        }
    }

    @Override
    public String getDescripcionDescuento() {
        return aplicarPorItem ? "Descuento por cantidad de items individuales"
                : "Descuento por cantidad total de productos";
    }

    @Override
    public String getTipoDescuento() {
        return "CANTIDAD";
    }

    public String getInformacionNiveles() {
        StringBuilder info = new StringBuilder("Niveles de descuento configurados:\n");
        for (NivelDescuento nivel : nivelesDescuento) info.append("- ").append(nivel).append("\n");
        info.append("Aplicación: ").append(aplicarPorItem ? "Por item individual" : "Por total de items");
        return info.toString();
    }

    @Override
    public String toString() {
        return String.format("DescuentoCantidad{niveles=%d, aplicarPorItem=%s}", nivelesDescuento.size(), aplicarPorItem);
    }
}


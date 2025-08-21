package co.edu.uniquindio.poo.cafeteria.model;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de descuento por hora feliz.
 * Aplica descuentos especiales durante franjas horarias específicas.
 */
public class DescuentoHoraFeliz implements EstrategiaDescuento {

    /**
     * Clase interna para definir una franja horaria de descuento.
     */
    public static class FranjaHoraria {
        private final LocalTime horaInicio;
        private final LocalTime horaFin;
        private final double porcentajeDescuento;
        private final String nombre;
        private final boolean activaFinDeSemana;

        public FranjaHoraria(LocalTime horaInicio, LocalTime horaFin, double porcentajeDescuento, String nombre) {
            this(horaInicio, horaFin, porcentajeDescuento, nombre, true);
        }

        public FranjaHoraria(LocalTime horaInicio, LocalTime horaFin, double porcentajeDescuento,
                             String nombre, boolean activaFinDeSemana) {
            if (horaInicio == null || horaFin == null) {
                throw new IllegalArgumentException("Las horas no pueden ser nulas");
            }
            if (porcentajeDescuento < 0 || porcentajeDescuento > 1) {
                throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 1");
            }

            this.horaInicio = horaInicio;
            this.horaFin = horaFin;
            this.porcentajeDescuento = porcentajeDescuento;
            this.nombre = nombre != null ? nombre : "Hora Feliz";
            this.activaFinDeSemana = activaFinDeSemana;
        }

        public LocalTime getHoraInicio() { return horaInicio; }
        public LocalTime getHoraFin() { return horaFin; }
        public double getPorcentajeDescuento() { return porcentajeDescuento; }
        public String getNombre() { return nombre; }
        public boolean isActivaFinDeSemana() { return activaFinDeSemana; }

        /**
         * Verifica si una hora está dentro de esta franja.
         */
        public boolean contieneHora(LocalTime hora) {
            if (horaInicio.isBefore(horaFin)) {
                // Franja normal (ej: 14:00 a 16:00)
                return !hora.isBefore(horaInicio) && !hora.isAfter(horaFin);
            } else {
                // Franja que cruza medianoche (ej: 22:00 a 02:00)
                return !hora.isBefore(horaInicio) || !hora.isAfter(horaFin);
            }
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return String.format("%s: %s - %s (%.0f%% descuento)%s",
                    nombre,
                    horaInicio.format(formatter),
                    horaFin.format(formatter),
                    porcentajeDescuento * 100,
                    activaFinDeSemana ? "" : " - Solo días laborales");
        }
    }

    private final List<FranjaHoraria> franjasHorarias;
    private boolean aplicarMejorDescuento; // true = mejor descuento, false = acumular

    /**
     * Constructor con configuración predeterminada de hora feliz.
     */
    public DescuentoHoraFeliz() {
        this.franjasHorarias = new ArrayList<>();
        this.aplicarMejorDescuento = true;
        configurarFranjasPredeterminadas();
    }

    public DescuentoHoraFeliz(LocalTime horaInicio, LocalTime horaFin, double porcentajeDescuento) {
        this.franjasHorarias = new ArrayList<>();
        this.aplicarMejorDescuento = true;
        agregarFranjaHoraria(horaInicio, horaFin, porcentajeDescuento, "Hora Feliz");
    }

    public DescuentoHoraFeliz(LocalTime horaInicio, LocalTime horaFin, double porcentajeDescuento,
                              String nombre, boolean activaFinDeSemana) {
        this.franjasHorarias = new ArrayList<>();
        this.aplicarMejorDescuento = true;
        agregarFranjaHoraria(horaInicio, horaFin, porcentajeDescuento, nombre, activaFinDeSemana);
    }

    private void configurarFranjasPredeterminadas() {
        agregarFranjaHoraria(LocalTime.of(7, 0), LocalTime.of(9, 0), 0.10, "Hora Feliz Matutina", false);
        agregarFranjaHoraria(LocalTime.of(14, 0), LocalTime.of(16, 0), 0.15, "Hora Feliz Vespertina");
        agregarFranjaHoraria(LocalTime.of(19, 0), LocalTime.of(21, 0), 0.12, "Hora Feliz Nocturna");
        agregarFranjaHoraria(LocalTime.of(10, 0), LocalTime.of(12, 0), 0.20, "Brunch de Fin de Semana", true);
    }

    public void agregarFranjaHoraria(LocalTime horaInicio, LocalTime horaFin, double porcentajeDescuento, String nombre) {
        agregarFranjaHoraria(horaInicio, horaFin, porcentajeDescuento, nombre, true);
    }

    public void agregarFranjaHoraria(LocalTime horaInicio, LocalTime horaFin, double porcentajeDescuento,
                                     String nombre, boolean activaFinDeSemana) {
        FranjaHoraria franja = new FranjaHoraria(horaInicio, horaFin, porcentajeDescuento, nombre, activaFinDeSemana);
        franjasHorarias.add(franja);
        franjasHorarias.sort((a, b) -> Double.compare(b.getPorcentajeDescuento(), a.getPorcentajeDescuento()));
    }

    public void setAplicarMejorDescuento(boolean aplicarMejorDescuento) {
        this.aplicarMejorDescuento = aplicarMejorDescuento;
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        if (!esAplicable(pedido)) return 0.0;

        LocalDateTime fechaPedido = pedido.getFechaPedido() != null ?
                convertirALocalDateTime(pedido.getFechaPedido()) :
                LocalDateTime.now();

        List<FranjaHoraria> franjasActivas = obtenerFranjasActivas(fechaPedido);
        if (franjasActivas.isEmpty()) return 0.0;

        double subtotal = pedido.getSubtotal();

        if (aplicarMejorDescuento) {
            return subtotal * franjasActivas.get(0).getPorcentajeDescuento();
        } else {
            double porcentajeTotal = franjasActivas.stream()
                    .mapToDouble(FranjaHoraria::getPorcentajeDescuento)
                    .sum();
            porcentajeTotal = Math.min(porcentajeTotal, 0.50); // Máx. 50%
            return subtotal * porcentajeTotal;
        }
    }

    private List<FranjaHoraria> obtenerFranjasActivas(LocalDateTime fechaHora) {
        LocalTime hora = fechaHora.toLocalTime();
        boolean esFinDeSemana = fechaHora.getDayOfWeek().getValue() >= 6;
        return franjasHorarias.stream()
                .filter(franja -> franja.contieneHora(hora))
                .filter(franja -> !esFinDeSemana || franja.isActivaFinDeSemana())
                .toList();
    }

    private LocalDateTime convertirALocalDateTime(java.util.Date date) {
        return date.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDateTime();
    }

    @Override
    public boolean esAplicable(Pedido pedido) {
        if (pedido == null) return false;
        LocalDateTime fechaPedido = pedido.getFechaPedido() != null ?
                convertirALocalDateTime(pedido.getFechaPedido()) :
                LocalDateTime.now();
        return !obtenerFranjasActivas(fechaPedido).isEmpty();
    }

    public boolean esHoraFelizActual() {
        return !obtenerFranjasActivas(LocalDateTime.now()).isEmpty();
    }

    public FranjaHoraria getMejorFranjaActual() {
        List<FranjaHoraria> activas = obtenerFranjasActivas(LocalDateTime.now());
        return activas.isEmpty() ? null : activas.get(0);
    }

    @Override
    public String getDescripcionDescuento() {
        return esHoraFelizActual()
                ? (getMejorFranjaActual() != null ? getMejorFranjaActual().getNombre() : "Hora Feliz Activa")
                : "Descuento por Hora Feliz";
    }

    @Override
    public String getTipoDescuento() {
        return "HORA_FELIZ";
    }

    public String getInformacionFranjas() {
        StringBuilder info = new StringBuilder("Franjas de Hora Feliz configuradas:\n");
        for (FranjaHoraria franja : franjasHorarias) {
            info.append("- ").append(franja).append("\n");
        }
        info.append("Aplicación: ").append(aplicarMejorDescuento ? "Mejor descuento" : "Descuentos acumulados");
        return info.toString();
    }

    public String getProximaHoraFeliz() {
        LocalTime horaActual = LocalTime.now();
        boolean esFinDeSemana = LocalDateTime.now().getDayOfWeek().getValue() >= 6;

        return franjasHorarias.stream()
                .filter(franja -> !esFinDeSemana || franja.isActivaFinDeSemana())
                .filter(franja -> franja.getHoraInicio().isAfter(horaActual))
                .min((a, b) -> a.getHoraInicio().compareTo(b.getHoraInicio()))
                .map(franja -> "Próxima: " + franja)
                .orElse("No hay más horas felices programadas para hoy");
    }

    @Override
    public String toString() {
        return String.format("DescuentoHoraFeliz{franjas=%d, mejorDescuento=%s, activa=%s}",
                franjasHorarias.size(), aplicarMejorDescuento, esHoraFelizActual());
    }
}




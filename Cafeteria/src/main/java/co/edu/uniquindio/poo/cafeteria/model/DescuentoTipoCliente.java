package co.edu.uniquindio.poo.cafeteria.model;

public class DescuentoTipoCliente implements EstrategiaDescuento {

    private Cliente cliente;

    /**
     * Constructor que recibe un cliente específico
     * (Estudiante, Docente o Visitante).
     */
    public DescuentoTipoCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public double calcularDescuento(double total) {
        if (cliente instanceof Estudiante) {
            return total * 0.10; // 10% para estudiantes
        } else if (cliente instanceof Docente) {
            return total * 0.15; // 15% para docentes
        } else if (cliente instanceof Visitante) {
            return total * 0.05; // 5% para visitantes
        }
        return 0; // sin descuento si no es un tipo conocido
    }

    @Override
    public String descripcionDescuento() {
        if (cliente instanceof Estudiante) {
            return "Descuento del 10% para estudiantes";
        } else if (cliente instanceof Docente) {
            return "Descuento del 15% para docentes";
        } else if (cliente instanceof Visitante) {
            return "Descuento del 5% para visitantes";
        }
        return "Sin descuento disponible";
    }
}


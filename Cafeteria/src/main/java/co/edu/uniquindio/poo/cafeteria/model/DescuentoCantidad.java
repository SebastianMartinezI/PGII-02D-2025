package co.edu.uniquindio.poo.cafeteria.model;

public class DescuentoCantidad implements EstrategiaDescuento {

    private final int cantidadMinima; // cantidad requerida para aplicar descuento
    private final double porcentajeDescuento; // porcentaje a aplicar

    public DescuentoCantidad(int cantidadMinima, double porcentajeDescuento) {
        this.cantidadMinima = cantidadMinima;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public double calcularDescuento(double total) {
        return total * porcentajeDescuento; // siempre aplica descuento
    }


    @Override
    public String descripcionDescuento() {
        return "Descuento del " + (porcentajeDescuento * 100) +
                "% por compras de al menos " + cantidadMinima + " productos.";
    }

    @Override
    public String toString() {
        return "DescuentoCantidad{" +
                "cantidadMinima=" + cantidadMinima +
                ", porcentajeDescuento=" + (porcentajeDescuento * 100) + "%" +
                '}';
    }
}

package co.edu.uniquindio.poo.cafeteria.model;

/**
 * Representa un docente de la universidad.
 * Los docentes tienen descuentos moderados y información académica específica.
 */
public class Docente extends Cliente {
    private final String codigoEmpleado;
    private final String departamento;
    private String rangoAcademico;

    private static final double DESCUENTO_BASE_DOCENTE = 0.10; // 10% de descuento
    private static final double DESCUENTO_DOCENTE_SENIOR = 0.12; // 12% para docentes senior

    /**
     * Constructor para crear un docente
     * @param nombre Nombre completo del docente
     * @param email Correo electrónico institucional
     * @param codigoEmpleado Código único de empleado
     * @param departamento Departamento al que pertenece
     * @param rangoAcademico Rango académico (Instructor, Asistente, Asociado, Titular)
     */
    public Docente(String nombre, String email, String codigoEmpleado, String departamento, String rangoAcademico) {
        super(nombre, email);

        if (codigoEmpleado == null || codigoEmpleado.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de empleado no puede estar vacío");
        }
        if (departamento == null || departamento.trim().isEmpty()) {
            throw new IllegalArgumentException("El departamento no puede estar vacío");
        }
        if (!validarRangoAcademico(rangoAcademico)) {
            throw new IllegalArgumentException("Rango académico inválido. Debe ser: Instructor, Asistente, Asociado o Titular");
        }

        this.codigoEmpleado = codigoEmpleado.trim().toUpperCase();
        this.departamento = departamento.trim();
        this.rangoAcademico = rangoAcademico.trim();
    }

    // ================== Getters ==================
    public String getCodigoEmpleado() { return codigoEmpleado; }
    public String getDepartamento() { return departamento; }
    public String getRangoAcademico() { return rangoAcademico; }

    // Setter para rango académico (puede cambiar por promociones)
    public void setRangoAcademico(String rangoAcademico) {
        if (!validarRangoAcademico(rangoAcademico)) {
            throw new IllegalArgumentException("Rango académico inválido");
        }
        this.rangoAcademico = rangoAcademico.trim();
    }

    // ================== Métodos propios ==================

    /**
     * Verifica si el docente tiene rango senior (Asociado o Titular)
     * @return true si es docente senior
     */
    public boolean esDocenteSenior() {
        return rangoAcademico.equalsIgnoreCase("Asociado") || rangoAcademico.equalsIgnoreCase("Titular");
    }

    /**
     * Valida que el rango académico sea uno de los permitidos
     * @param rango Rango a validar
     * @return true si es válido
     */
    private boolean validarRangoAcademico(String rango) {
        if (rango == null) return false;
        String rangoLimpio = rango.trim();
        return rangoLimpio.equalsIgnoreCase("Instructor") ||
                rangoLimpio.equalsIgnoreCase("Asistente") ||
                rangoLimpio.equalsIgnoreCase("Asociado") ||
                rangoLimpio.equalsIgnoreCase("Titular");
    }

    // ================== Implementación de métodos abstractos ==================

    @Override
    public String getTipoCliente() {
        return "Docente";
    }

    @Override
    public double getTasaDescuentoBase() {
        // Los docentes senior obtienen mayor descuento
        return esDocenteSenior() ? DESCUENTO_DOCENTE_SENIOR : DESCUENTO_BASE_DOCENTE;
    }

    @Override
    public String getInformacionAdicional() {
        StringBuilder info = new StringBuilder();
        info.append("Código: ").append(codigoEmpleado);
        info.append(", Departamento: ").append(departamento);
        info.append(", Rango: ").append(rangoAcademico);

        if (esDocenteSenior()) {
            info.append(" (Docente Senior)");
        }

        if (esClienteFrecuente()) {
            info.append(" - Cliente Frecuente");
        }

        return info.toString();
    }

    // ================== toString ==================
    @Override
    public String toString() {
        return String.format(
                "Docente{id=%d, nombre='%s', código='%s', departamento='%s', rango='%s', pedidos=%d, totalGastado=%.2f, descuento=%.0f%%}",
                getIdCliente(), getNombre(), codigoEmpleado, departamento, rangoAcademico,
                getCantidadPedidos(), calcularTotalGastado(),
                getTasaDescuentoBase() * 100
        );
    }
}


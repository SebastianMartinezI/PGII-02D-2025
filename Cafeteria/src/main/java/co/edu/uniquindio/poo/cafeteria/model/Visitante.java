package co.edu.uniquindio.poo.cafeteria.model;

/**
 * Representa un visitante externo a la universidad.
 * Los visitantes no tienen descuentos base, pero pueden ser promocionados a clientes frecuentes.
 */
public class Visitante extends Cliente {
    private String documentoId;
    private String institucion;
    private String tipoVisita;

    // Descuentos aplicables a visitantes
    private static final double DESCUENTO_BASE_VISITANTE = 0.0; // Sin descuento base
    private static final double DESCUENTO_VISITANTE_FRECUENTE = 0.05; // 5% si es frecuente

    /**
     * Constructor para crear un visitante con valores por defecto.
     *
     * @param nombre Nombre completo del visitante
     * @param email Correo electrónico del visitante
     * @param documentoId Documento de identificación (obligatorio)
     * @param institucion Institución de procedencia (opcional)
     */
    public Visitante(String nombre, String email, String documentoId, String institucion) {
        super(nombre, email);

        if (documentoId == null || documentoId.trim().isEmpty()) {
            throw new IllegalArgumentException("El documento de identificación no puede estar vacío");
        }

        this.documentoId = documentoId.trim();
        this.institucion = limpiarInstitucion(institucion);
        this.tipoVisita = "General"; // Valor por defecto
    }

    /**
     * Constructor completo para crear un visitante con tipo de visita.
     *
     * @param nombre Nombre completo del visitante
     * @param email Correo electrónico del visitante
     * @param documentoId Documento de identificación
     * @param institucion Institución de procedencia
     * @param tipoVisita Tipo de visita (Académico, Administrativo, Personal, etc.)
     */
    public Visitante(String nombre, String email, String documentoId, String institucion, String tipoVisita) {
        this(nombre, email, documentoId, institucion);
        this.tipoVisita = limpiarTipoVisita(tipoVisita);
    }

    // ===== Getters =====

    public String getDocumentoId() {
        return documentoId;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getTipoVisita() {
        return tipoVisita;
    }

    // ===== Setters =====

    public void setInstitucion(String institucion) {
        this.institucion = limpiarInstitucion(institucion);
    }

    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = limpiarTipoVisita(tipoVisita);
    }

    // ===== Métodos auxiliares =====

    private String limpiarInstitucion(String institucion) {
        return (institucion != null && !institucion.trim().isEmpty()) ? institucion.trim() : "No especificada";
    }

    private String limpiarTipoVisita(String tipoVisita) {
        return (tipoVisita != null && !tipoVisita.trim().isEmpty()) ? tipoVisita.trim() : "General";
    }

    /**
     * Verifica si el visitante tiene un perfil académico.
     *
     * @return true si el visitante está relacionado con una institución académica
     */
    public boolean esVisitanteAcademico() {
        if (institucion == null) return false;
        String inst = institucion.toLowerCase();
        return tipoVisita.equalsIgnoreCase("Académico") ||
                inst.contains("universidad") ||
                inst.contains("instituto") ||
                inst.contains("colegio");
    }

    /**
     * Verifica si el visitante tiene institución especificada.
     *
     * @return true si tiene institución válida
     */
    public boolean tieneInstitucion() {
        return institucion != null && !institucion.equals("No especificada") && !institucion.isEmpty();
    }

    // ===== Implementación de Cliente =====

    @Override
    public String getTipoCliente() {
        return "Visitante";
    }

    @Override
    public double getTasaDescuentoBase() {
        return esClienteFrecuente() ? DESCUENTO_VISITANTE_FRECUENTE : DESCUENTO_BASE_VISITANTE;
    }

    @Override
    public String getInformacionAdicional() {
        StringBuilder info = new StringBuilder();
        info.append("Documento: ").append(documentoId);

        if (tieneInstitucion()) {
            info.append(", Institución: ").append(institucion);
        }

        info.append(", Tipo de visita: ").append(tipoVisita);

        if (esVisitanteAcademico()) {
            info.append(" (Visitante Académico)");
        }

        if (esClienteFrecuente()) {
            info.append(" - Cliente Frecuente");
        }

        return info.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "Visitante {id=%d, nombre='%s', documento='%s', institucion='%s', tipo='%s', descuento=%.0f%%}",
                idCliente, nombre, documentoId, institucion, tipoVisita,
                getTasaDescuentoBase() * 100
        );
    }
}

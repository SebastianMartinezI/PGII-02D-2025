package co.edu.uniquindio.poo.cafeteria.model;

/**
 * Representa un estudiante de la universidad.
 * Los estudiantes tienen descuentos especiales y cuentan con información académica adicional.
 */
public class Estudiante extends Cliente {
    private String codigoEstudiante;
    private String carrera;
    private int semestre;

    // Descuentos aplicables a estudiantes
    private static final double DESCUENTO_BASE_ESTUDIANTE = 0.15; // 15%
    private static final double DESCUENTO_ESTUDIANTE_FRECUENTE = 0.20; // 20% si es frecuente

    /**
     * Constructor para crear un estudiante.
     *
     * @param nombre Nombre completo del estudiante
     * @param email Correo electrónico institucional
     * @param codigoEstudiante Código único del estudiante
     * @param carrera Carrera que estudia
     * @param semestre Semestre actual (1-10)
     * @throws IllegalArgumentException si los datos son inválidos
     */
    public Estudiante(String nombre, String email, String codigoEstudiante, String carrera, int semestre) {
        super(nombre, email);

        if (codigoEstudiante == null || codigoEstudiante.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de estudiante no puede estar vacío");
        }
        if (carrera == null || carrera.trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede estar vacía");
        }
        validarSemestre(semestre);

        this.codigoEstudiante = codigoEstudiante.trim().toUpperCase();
        this.carrera = carrera.trim();
        this.semestre = semestre;
    }

    // ===== Getters =====

    /**
     * @return Código único del estudiante
     */
    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    /**
     * @return Carrera que estudia el estudiante
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @return Semestre actual del estudiante
     */
    public int getSemestre() {
        return semestre;
    }

    // ===== Setters =====

    /**
     * Modifica el semestre del estudiante.
     *
     * @param semestre Nuevo semestre (1-10)
     * @throws IllegalArgumentException si no está en el rango válido
     */
    public void setSemestre(int semestre) {
        validarSemestre(semestre);
        this.semestre = semestre;
    }

    // ===== Métodos auxiliares =====

    private void validarSemestre(int semestre) {
        if (semestre < 1 || semestre > 10) {
            throw new IllegalArgumentException("El semestre debe estar entre 1 y 10");
        }
    }

    /**
     * @return true si el estudiante está en semestres avanzados (7 a 10)
     */
    public boolean esEstudianteAvanzado() {
        return semestre >= 7;
    }

    /**
     * @return true si el estudiante pertenece a primer año (semestres 1 o 2)
     */
    public boolean esPrimerAño() {
        return semestre <= 2;
    }

    // ===== Implementación de Cliente =====

    @Override
    public String getTipoCliente() {
        return "Estudiante";
    }

    @Override
    public double getTasaDescuentoBase() {
        return esClienteFrecuente() ? DESCUENTO_ESTUDIANTE_FRECUENTE : DESCUENTO_BASE_ESTUDIANTE;
    }

    @Override
    public String getInformacionAdicional() {
        StringBuilder info = new StringBuilder();
        info.append("Código: ").append(codigoEstudiante)
                .append(", Carrera: ").append(carrera)
                .append(", Semestre: ").append(semestre);

        if (esEstudianteAvanzado()) {
            info.append(" (Estudiante Avanzado)");
        } else if (esPrimerAño()) {
            info.append(" (Primer Año)");
        }

        if (esClienteFrecuente()) {
            info.append(" - Cliente Frecuente");
        }

        return info.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "Estudiante {id=%d, nombre='%s', código='%s', carrera='%s', semestre=%d, descuento=%.0f%%}",
                idCliente, nombre, codigoEstudiante, carrera, semestre,
                getTasaDescuentoBase() * 100
        );
    }
}

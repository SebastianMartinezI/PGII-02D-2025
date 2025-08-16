package co.edu.uniquindio.poo.veterinaria.model;
public class Historial {
    private int idHistorial;
    private Consulta consulta;

    /**
     * Construye un nuevo historial con el identificador y la consulta asociada.
     *
     * @param idHistorial identificador único del historial
     * @param consulta    consulta que hace parte del historial médico
     */
    public Historial(int idHistorial, Consulta consulta) {
        this.idHistorial = idHistorial;
        this.consulta = consulta;
    }
}


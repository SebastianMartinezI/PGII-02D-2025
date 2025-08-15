package co.edu.uniquindio.poo.veterinaria.model;
public class Historial {
    private int idHistorial;
    private Consulta consulta;

    public Historial(int idHistorial, Consulta consulta) {
        this.idHistorial = idHistorial;
        this.consulta = consulta;
    }
}


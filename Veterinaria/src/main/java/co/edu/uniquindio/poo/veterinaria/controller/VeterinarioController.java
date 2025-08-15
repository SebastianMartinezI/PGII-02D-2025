package co.edu.uniquindio.poo.veterinaria.controller;

import co.edu.uniquindio.poo.veterinaria.model.Veterinario;
import co.edu.uniquindio.poo.veterinaria.model.Veterinaria;
import java.util.Collection;

public class VeterinarioController {

    Veterinaria veterinaria;

    public VeterinarioController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public boolean crearVeterinario(Veterinario veterinario) {
        return veterinaria.agregarVeterinario(veterinario);
    }

    public Collection<Veterinario> obtenerListaVeterinarios() {
        return veterinaria.getListVeterinarios();
    }

    public boolean eliminarVeterinario(String identificacion) {
        return veterinaria.eliminarVeterinario(identificacion);
    }

    public boolean actualizarVeterinario(String identificacion, Veterinario veterinario) {
        return veterinaria.actualizarVeterinario(identificacion, veterinario);
    }
}
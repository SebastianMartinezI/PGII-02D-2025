package co.edu.uniquindio.poo.veterinaria.controller;

import co.edu.uniquindio.poo.veterinaria.model.Mascota;
import co.edu.uniquindio.poo.veterinaria.model.Veterinaria;
import java.util.Collection;

public class MascotaController {

    Veterinaria veterinaria;

    public MascotaController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public boolean crearMascota(Mascota mascota) {
        return veterinaria.agregarMascota(mascota);
    }

    public Collection<Mascota> obtenerListaMascotas() {
        return veterinaria.getListMascotas();
    }

    public boolean eliminarMascota(String identificacionVeterinaria) {
        return veterinaria.eliminarMascota(identificacionVeterinaria);
    }

    public boolean actualizarMascota(String identificacionVeterinaria, Mascota mascota) {
        return veterinaria.actualizarMascota(identificacionVeterinaria, mascota);
    }
}

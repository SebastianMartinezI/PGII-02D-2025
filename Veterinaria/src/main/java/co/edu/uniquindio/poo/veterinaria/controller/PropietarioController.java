package co.edu.uniquindio.poo.veterinaria.controller;

import co.edu.uniquindio.poo.veterinaria.model.Propietario;
import co.edu.uniquindio.poo.veterinaria.model.Veterinaria;
import java.util.Collection;

public class PropietarioController {

    Veterinaria veterinaria;

    public PropietarioController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public boolean crearPropietario(Propietario propietario) {
        return veterinaria.agregarPropietario(propietario);
    }

    public Collection<Propietario> obtenerListaPropietarios() {
        return veterinaria.getListPropietarios();
    }

    public boolean eliminarPropietario(String identificacion) {
        return veterinaria.eliminarPropietario(identificacion);
    }

    public boolean actualizarPropietario(String identificacion, Propietario propietario) {
        return veterinaria.actualizarPropietario(identificacion, propietario);
    }
}


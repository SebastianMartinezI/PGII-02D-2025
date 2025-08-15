package co.edu.uniquindio.poo.veterinaria.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Veterinaria {
    private String nombre;
    private String direccion;
    private int telefono;
    private Collection<Mascota> listMascotas;
    private Collection<Propietario> listPropietarios;
    private Collection<Veterinario> listVeterinarios;
    private Collection<Consulta> listConsultas;


    public Veterinaria(String nombre, String direccion, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        listMascotas = new LinkedList<>();
        listPropietarios = new LinkedList<>();
        listVeterinarios = new LinkedList<>();
        listConsultas = new LinkedList<>();

    }

    /**
     * Metodo para agregar una mascota a la lista.
     */

    public Collection<Veterinario> getListVeterinarios() {
        return listVeterinarios;
    }

    public void setListVeterinarios(Collection<Veterinario> listVeterinarios) {
        this.listVeterinarios = listVeterinarios;
    }

    public Collection<Consulta> getListConsultas() {
        return listConsultas;
    }

    public void setListConsultas(Collection<Consulta> listConsultas) {
        this.listConsultas = listConsultas;
    }

    public Collection<Propietario> getListPropietarios() {
        return listPropietarios;
    }

    public void setListPropietarios(List<Propietario> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }

    public Collection<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public boolean agregarVeterinario(Veterinario veterinario) {
        boolean centinela = false;
        if (!verificarVeterinario(veterinario.getIdentificacion())) {
            listVeterinarios.add(veterinario);
            centinela = true;
        }
        return centinela;
    }

    public boolean agregarPropietario(Propietario propietario) {
        boolean centinela = false;
        if (!verificarPropietario(propietario.getIdentificacion())) {
            listPropietarios.add(propietario);
            centinela = true;
        }
        return centinela;
    }
    public boolean agregarMascota(Mascota mascota) {
        boolean centinela = false;
        if (!verificarMascota(mascota.getIdentificacionVeterinaria())) {
            listMascotas.add(mascota);
            centinela = true;
        }
        return centinela;
    }
    public boolean verificarVeterinario(String identificacion) {
        boolean centinela = false;
        for (Veterinario veterinario : listVeterinarios) {
            if (veterinario.getIdentificacion().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public boolean verificarPropietario(String identificacion) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getIdentificacion().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public boolean verificarMascota(String identificacionVeterinaria) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getIdentificacionVeterinaria().equals(identificacionVeterinaria)) {
                centinela = true;
            }
        }
        return centinela;
    }


    public boolean agregarConsulta(Consulta consulta) {
        boolean centinela = false;
        if (!verificarConsulta(consulta.getMascota())) {
            listConsultas.add(consulta);
            centinela = true;
        }
        return centinela;
    }
    public boolean verificarConsulta(String mascota) {
        boolean centinela = false;
        for (Consulta consulta: listConsultas) {
            if (consulta.getMascota().equals(mascota)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /** Ver historial de una mascota */
  /**  public void verHistorialMascota(String mascota) {
        System.out.println("Historial de la mascota: " + nombre);
        for (Consulta consulta : listConsultas) {
            if (consulta.getMascota().equalsIgnoreCase(nombre)) {
                System.out.println(consulta);
            }
        }
    }*/



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public boolean eliminarPropietario(String identificacion) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getIdentificacion().equals(identificacion)) {
                listPropietarios.remove(propietario);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarVeterinario(String identificacion){
        boolean centinela = false;
        for (Veterinario veterinario : listVeterinarios) {
            if (veterinario.getIdentificacion().equals(identificacion)) {
                listVeterinarios.remove(veterinario);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarMascota(String identificacionVeterinaria){
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getIdentificacionVeterinaria().equals(identificacionVeterinaria)) {
                listMascotas.remove(mascota);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarMascota(String identidicacionVeterinaria, Mascota actualizado) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getIdentificacionVeterinaria().equals(identidicacionVeterinaria)) {
                mascota.setNombre(actualizado.getNombre());
                mascota.setEspecie(actualizado.getEspecie());
                mascota.setRaza(actualizado.getRaza());
                mascota.setEdad(actualizado.getEdad());
                mascota.setIdentificacionVeterinaria(actualizado.getIdentificacionVeterinaria());
                mascota.setPropietario(actualizado.getPropietario());

                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarPropietario(String identificacion, Propietario actualizado) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getIdentificacion().equals(identificacion)) {
                propietario.setNombre(actualizado.getNombre());
                propietario.setIdentificacion(actualizado.getIdentificacion());
                propietario.setTelefono(actualizado.getTelefono());
                propietario.setDireccion(actualizado.getDireccion());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarVeterinario(String identificacion, Veterinario actualizado) {
        boolean centinela = false;
        for (Veterinario veterinario : listVeterinarios) {
            if (veterinario.getIdentificacion().equals(identificacion)) {
                veterinario.setNombre(actualizado.getNombre());
                veterinario.setIdentificacion(actualizado.getIdentificacion());
                veterinario.setTelefono(actualizado.getTelefono());
                veterinario.setDireccion(actualizado.getDireccion());
                veterinario.setLicenciaProfesional(actualizado.getLicenciaProfesional());
                veterinario.setEspecialidad(actualizado.getEspecialidad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo para mostrar todas las mascotas registradas.
     */
    public void mostrarMascotas() {
        System.out.println("Mascotas en la veterinaria " + nombre + ":");
        for (Mascota m : listMascotas) {
            System.out.println("- " + m);
        }
    }
    /** Consultar citas por fecha (fecha en formato String, ej: "2025-08-08")
    public void consultarCitasPorFecha(String fecha) {
        System.out.println("Citas del día " + fecha + ":");
        for (Consulta consulta : listConsultas) {
            if (consulta.getFecha().equals(fecha)) {
                System.out.println(consulta);
            }
        }
    }
     */


    /** Funcionalidad propia: buscar propietario por ID */
    public Propietario buscarPropietarioPorID(String identificicacion) {
        for (Propietario propietario : listPropietarios) {
            if (propietario.getIdentificacion().equals(identificicacion)) {
                return propietario;
            }
        }
        return null;
    }
}


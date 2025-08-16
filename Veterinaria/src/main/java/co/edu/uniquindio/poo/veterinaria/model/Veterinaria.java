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

    /**
     * Constructor de la clase Veterinaria.
     *
     * @param nombre    Nombre de la veterinaria.
     * @param direccion Dirección donde está ubicada.
     * @param telefono  Número telefónico de contacto.
     */
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
     * Agrega un veterinario si no existe uno con la misma identificación.
     * @param veterinario Veterinario a registrar
     * @return true si se agregó, false si ya existía
     */
    public boolean agregarVeterinario(Veterinario veterinario) {
        boolean centinela = false;
        if (!verificarVeterinario(veterinario.getIdentificacion())) {
            listVeterinarios.add(veterinario);
            centinela = true;
        }
        return centinela;
    }

    /**
     * Agrega un propietario si no existe uno con la misma identificación.
     * @param propietario Propietario a registrar
     * @return true si se agregó, false si ya existía
     */
    public boolean agregarPropietario(Propietario propietario) {
        boolean centinela = false;
        if (!verificarPropietario(propietario.getIdentificacion())) {
            listPropietarios.add(propietario);
            centinela = true;
        }
        return centinela;
    }

    /**
     * Agrega una mascota si no existe otra con la misma identificación veterinaria.
     * @param mascota Mascota a registrar
     * @return true si se agregó, false si ya existía
     */
    public boolean agregarMascota(Mascota mascota) {
        boolean centinela = false;
        if (!verificarMascota(mascota.getIdentificacionVeterinaria())) {
            listMascotas.add(mascota);
            centinela = true;
        }
        return centinela;
    }

    /**
     * Verifica si ya existe un veterinario registrado.
     * @param identificacion Identificación a buscar
     * @return true si existe, false si no
     */
    public boolean verificarVeterinario(String identificacion) {
        boolean centinela = false;
        for (Veterinario veterinario : listVeterinarios) {
            if (veterinario.getIdentificacion().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Verifica si ya existe un propietario registrado.
     * @param identificacion Identificación a buscar
     * @return true si existe, false si no
     */
    public boolean verificarPropietario(String identificacion) {
        boolean centinela = false;
        for (Propietario propietario : listPropietarios) {
            if (propietario.getIdentificacion().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Verifica si ya existe una mascota registrada.
     * @param identificacionVeterinaria Identificación a buscar
     * @return true si existe, false si no
     */
    public boolean verificarMascota(String identificacionVeterinaria) {
        boolean centinela = false;
        for (Mascota mascota : listMascotas) {
            if (mascota.getIdentificacionVeterinaria().equals(identificacionVeterinaria)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Agrega una consulta si no existe ya registrada para esa mascota.
     * @param consulta Consulta a registrar
     * @return true si se agregó, false si ya existía
     */
    public boolean agregarConsulta(Consulta consulta) {
        boolean centinela = false;
        if (!verificarConsulta(consulta.getMascota())) {
            listConsultas.add(consulta);
            centinela = true;
        }
        return centinela;
    }

    /**
     * Verifica si una mascota ya tiene una consulta registrada.
     * @param mascota Nombre o identificador de la mascota
     * @return true si existe, false si no
     */
    public boolean verificarConsulta(String mascota) {
        boolean centinela = false;
        for (Consulta consulta: listConsultas) {
            if (consulta.getMascota().equals(mascota)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Elimina un propietario por su identificación.
     * @param identificacion Identificación a eliminar
     * @return true si se eliminó, false si no se encontró
     */
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

    /**
     * Elimina un veterinario por su identificación.
     * @param identificacion Identificación a eliminar
     * @return true si se eliminó, false si no se encontró
     */
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

    /**
     * Elimina una mascota por su identificación veterinaria.
     * @param identificacionVeterinaria Identificación a eliminar
     * @return true si se eliminó, false si no se encontró
     */
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

    /**
     * Actualiza la información de una mascota.
     * @param identidicacionVeterinaria Identificación de la mascota a actualizar
     * @param actualizado Datos nuevos
     * @return true si se actualizó, false si no se encontró
     */
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

    /**
     * Actualiza la información de un propietario.
     * @param identificacion Identificación del propietario a actualizar
     * @param actualizado Datos nuevos
     * @return true si se actualizó, false si no se encontró
     */
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

    /**
     * Actualiza la información de un veterinario.
     * @param identificacion Identificación del veterinario a actualizar
     * @param actualizado Datos nuevos
     * @return true si se actualizó, false si no se encontró
     */
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
     * Muestra todas las mascotas registradas en la veterinaria.
     */
    public void mostrarMascotas() {
        System.out.println("Mascotas en la veterinaria " + nombre + ":");
        for (Mascota m : listMascotas) {
            System.out.println("- " + m);
        }
    }

    /**
     * Busca un propietario por su identificación.
     * @param identificicacion Identificación a buscar
     * @return Propietario encontrado o null si no existe
     */
    public Propietario buscarPropietarioPorID(String identificicacion) {
        for (Propietario propietario : listPropietarios) {
            if (propietario.getIdentificacion().equals(identificicacion)) {
                return propietario;
            }
        }
        return null;
    }

    // Getters y Setters
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

    public void setListPropietarios(Collection<Propietario> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }

    public Collection<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(Collection<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

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
}

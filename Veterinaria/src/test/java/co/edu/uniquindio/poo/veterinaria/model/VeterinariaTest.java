package co.edu.uniquindio.poo.veterinaria.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Clase de pruebas unitarias para la clase {@link Veterinaria}.
 *
 * Cada test valida una funcionalidad específica del sistema de gestión veterinaria,
 * incluyendo la adición, verificación y eliminación de entidades como veterinarios,
 * propietarios, mascotas y consultas.
 */
class VeterinariaTest {

    /**
     * Verifica que se pueda agregar un veterinario correctamente.
     */
    @Test
    public void agregarVeterinario() {
        Veterinaria veterinaria = new Veterinaria("j","35",333);
        Veterinario vet1 = new Veterinario("carlos", "1222228", "82738","hpi","maestria","perros");
        assertTrue(veterinaria.agregarVeterinario(vet1));
    }

    /**
     * Verifica que se pueda agregar un propietario correctamente.
     */
    @Test
    void agregarPropietario() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Propietario pro1 = new Propietario("pedro","23","347962","oeste");
        assertTrue(veterinaria.agregarPropietario(pro1));
    }

    /**
     * Verifica que se pueda agregar una mascota correctamente.
     */
    @Test
    void agregarMascota() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Mascota mas1 = new Mascota("marlon","gato","nose","5","1222","lucho");
        assertTrue(veterinaria.agregarMascota(mas1));
    }

    /**
     * Verifica que un veterinario existente pueda ser localizado por su identificación.
     */
    @Test
    void verificarVeterinario() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Veterinario vet2 = new Veterinario("juan", "78", "82738","hpi","maestria","perros");
        veterinaria.agregarVeterinario(vet2);
        assertTrue(veterinaria.verificarVeterinario("78"));
    }

    /**
     * Verifica que un propietario existente pueda ser localizado por su identificación.
     */
    @Test
    void verificarPropietario() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Propietario pro2 = new Propietario("julian","23","347962","oeste");
        veterinaria.agregarPropietario(pro2);
        assertTrue(veterinaria.verificarPropietario("23"));
    }

    /**
     * Verifica que una mascota existente pueda ser localizada por su identificación.
     */
    @Test
    void verificarMascota() {
        Veterinaria veterinaria = new Veterinaria("j","13",333);
        Mascota mas2 = new Mascota("pelusa","gato","nose","5","1222","lucho");
        veterinaria.agregarMascota(mas2);
        assertTrue(veterinaria.verificarMascota("13"));
    }

    /**
     * Verifica que se pueda agregar una consulta correctamente.
     */
    @Test
    void agregarConsulta() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Consulta cons1 = new Consulta("12","12/02","perro","julian","fiebre","migraña","acetaminofen");
        assertTrue(veterinaria.agregarConsulta(cons1));
    }

    /**
     * Verifica que una consulta existente pueda ser localizada por su identificación.
     */
    @Test
    void verificarConsulta() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Consulta cons1 = new Consulta("12","12/02","perro","julian","fiebre","migraña","acetaminofen");
        veterinaria.agregarConsulta(cons1);
        assertTrue(veterinaria.verificarConsulta("12"));
    }

    /**
     * Verifica que se pueda eliminar un propietario existente.
     */
    @Test
    void eliminarPropietario() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Propietario pro3 = new Propietario("camilo","44","347962","oeste");
        veterinaria.agregarPropietario(pro3);
        assertTrue(veterinaria.eliminarPropietario("44"));
    }

    /**
     * Verifica que se pueda eliminar un veterinario existente.
     */
    @Test
    void eliminarVeterinario() {
        Veterinaria veterinaria = new Veterinaria("j","12",333);
        Veterinario vet3 = new Veterinario("juanes", "733", "82738","hpi","maestria","perros");
        veterinaria.agregarVeterinario(vet3);
        assertTrue(veterinaria.eliminarVeterinario("733"));
    }

    /**
     * Verifica que se pueda eliminar una mascota existente.
     */
    @Test
    void eliminarMascota() {
        Veterinaria veterinaria = new Veterinaria("j","13",333);
        Mascota mas3 = new Mascota("karonte","gato","nose","5","1","lucho");
        veterinaria.agregarMascota(mas3);
        assertTrue(veterinaria.eliminarMascota("1"));
    }
}
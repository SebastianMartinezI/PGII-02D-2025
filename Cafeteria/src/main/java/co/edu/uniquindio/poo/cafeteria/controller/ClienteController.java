package co.edu.uniquindio.poo.cafeteria.controller;

import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.Cliente;

import java.util.Collection;

/**
 * Controller para gestionar operaciones sobre clientes.
 */
public class ClienteController {

    private final Cafeteria cafeteria;

    public ClienteController(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    /**
     * Agrega un cliente a la cafetería.
     * @param cliente Cliente a agregar
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean crearCliente(Cliente cliente) {
        return cafeteria.agregarCliente(cliente);
    }

    /**
     * Obtiene todos los clientes registrados.
     * @return colección de clientes
     */
    public Collection<Cliente> obtenerClientes() {
        return cafeteria.getClientes();
    }

    /**
     * Elimina un cliente de la cafetería.
     * @param id Identificación del cliente
     * @return true si se eliminó correctamente, false si no existe
     */

     public boolean eliminarCliente(String id) {
        Cliente cliente = cafeteria.buscarClientePorNombre(id);
        if(cliente != null){
            return cafeteria.eliminarCliente(cliente);
        }
        return false;
    }

    /**
     * Actualiza la información de un cliente existente.
     * @param id Identificación del cliente a actualizar
     * @param nuevoCliente Objeto cliente con los datos actualizados
     * @return true si se actualizó correctamente, false si no existe
     */

}

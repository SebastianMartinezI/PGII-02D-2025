package co.edu.uniquindio.poo.cafeteria.controller;

import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.Producto;

import java.util.Collection;

/**
 * Controller para gestionar operaciones sobre productos.
 */
public class ProductoController {

    private final Cafeteria cafeteria;

    public ProductoController(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    /**
     * Agrega un producto a la cafetería.
     * @param producto Producto a agregar
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean crearProducto(Producto producto) {
        return cafeteria.agregarProducto(producto);
    }

    /**
     * Obtiene todos los productos registrados.
     * @return colección de productos
     */
    public Collection<Producto> obtenerProductos() {
        return cafeteria.getProductos();
    }

    /**
     * Elimina un producto de la cafetería.
     * @param nombre Nombre del producto a eliminar
     * @return true si se eliminó correctamente, false si no existe
     */
    public boolean eliminarProducto(String nombre) {

            return cafeteria.eliminarProducto(nombre);
        }

    /**
     * Actualiza la información de un producto existente.
     * @param nombre Nombre del producto a actualizar
     * @param nuevoProducto Objeto producto con los datos actualizados
     * @return true si se actualizó correctamente, false si no existe
     */
    public boolean actualizarProducto(String nombre, Producto nuevoProducto) {
        Producto productoExistente = cafeteria.buscarProductoPorNombre(nombre);
        if(productoExistente != null){
            productoExistente.setNombre(nuevoProducto.getNombre());
            productoExistente.setPrecio(nuevoProducto.getPrecio());

            return true;
        }
        return false;
    }
}

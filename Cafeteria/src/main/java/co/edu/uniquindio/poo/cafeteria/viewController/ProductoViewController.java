package co.edu.uniquindio.poo.cafeteria.viewController;

import co.edu.uniquindio.poo.cafeteria.App;
import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoViewController {

    private App app;
    private Cafeteria cafeteria = App.cafeteria;

    @FXML private TableView<Producto> tableProductos;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colStock;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    private ObservableList<Producto> listaProductos;

    public void setApp(App app) {
        this.app = app;
        cargarProductos();
    }

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }

    private void cargarProductos() {
        listaProductos = FXCollections.observableArrayList(cafeteria.getProductos());
        tableProductos.setItems(listaProductos);
    }

    @FXML
    private void agregarProducto() {
        String nombre = txtNombre.getText();
        double precio;
        int stock;

        try {
            precio = Double.parseDouble(txtPrecio.getText());
            stock = Integer.parseInt(txtStock.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Precio y Stock deben ser numéricos");
            return;
        }

        if(nombre.isEmpty()) {
            showAlert("Error", "Debe ingresar un nombre");
            return;
        }


        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();
    }

    @FXML
    private void eliminarProducto() {
        Producto seleccionado = tableProductos.getSelectionModel().getSelectedItem();
        if(seleccionado != null) {
            cafeteria.eliminarProducto(seleccionado.getNombre());
            listaProductos.remove(seleccionado);
        } else {
            showAlert("Error", "Debe seleccionar un producto");
        }
    }

    private void showAlert(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

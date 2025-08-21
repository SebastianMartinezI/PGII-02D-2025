package co.edu.uniquindio.poo.cafeteria.viewController;

import co.edu.uniquindio.poo.cafeteria.App;
import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteViewController {

    private App app;
    private Cafeteria cafeteria = App.cafeteria;

    @FXML private TableView<Cliente> tableClientes;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtId;
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    private ObservableList<Cliente> listaClientes;

    public void setApp(App app) {
        this.app = app;
        cargarClientes();
    }

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    private void cargarClientes() {
        listaClientes = FXCollections.observableArrayList(cafeteria.getClientes());
        tableClientes.setItems(listaClientes);
    }

    @FXML
    private void agregarCliente() {
        String nombre = txtNombre.getText();
        String id = txtId.getText();

        if(nombre.isEmpty() || id.isEmpty()) {
            showAlert("Error", "Debe completar todos los campos");
            return;
        }

        Cliente cliente = new Cliente(nombre, id);
        cafeteria.agregarCliente(cliente);
        listaClientes.add(cliente);
        txtNombre.clear();
        txtId.clear();
    }

    @FXML
    private void eliminarCliente() {
        Cliente seleccionado = tableClientes.getSelectionModel().getSelectedItem();
        if(seleccionado != null) {
            cafeteria.eliminarCliente(seleccionado);
            listaClientes.remove(seleccionado);
        } else {
            showAlert("Error", "Debe seleccionar un cliente");
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


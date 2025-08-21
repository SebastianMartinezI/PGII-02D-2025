package co.edu.uniquindio.poo.cafeteria.viewController;

import co.edu.uniquindio.poo.cafeteria.App;
import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.Cliente;
import co.edu.uniquindio.poo.cafeteria.model.Pedido;
import co.edu.uniquindio.poo.cafeteria.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PedidoViewController {

    private App app;
    private Cafeteria cafeteria = App.cafeteria;

    @FXML private TableView<Pedido> tablePedidos;
    @FXML private TableColumn<Pedido, String> colCliente;
    @FXML private TableColumn<Pedido, String> colProductos;
    @FXML private TableColumn<Pedido, Double> colTotal;

    @FXML private ComboBox<Cliente> cmbCliente;
    @FXML private ComboBox<Producto> cmbProducto;
    @FXML private TextField txtCantidad;
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    private ObservableList<Pedido> listaPedidos;

    public void setApp(App app) {
        this.app = app;
        cargarPedidos();
        cargarClientes();
        cargarProductos();
    }

    @FXML
    private void initialize() {
        colCliente.setCellValueFactory(data -> data.getValue().getCliente().nombreProperty());
        colProductos.setCellValueFactory(data -> data.getValue().productosToStringProperty());
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void cargarPedidos() {
        listaPedidos = FXCollections.observableArrayList(cafeteria.getPedidos());
        tablePedidos.setItems(listaPedidos);
    }

    private void cargarClientes() {
        cmbCliente.setItems(FXCollections.observableArrayList(cafeteria.getClientes()));
    }

    private void cargarProductos() {
        cmbProducto.setItems(FXCollections.observableArrayList(cafeteria.getProductos()));
    }

    @FXML
    private void agregarPedido() {
        Cliente cliente = cmbCliente.getValue();
        Producto producto = cmbProducto.getValue();
        int cantidad;

        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Cantidad debe ser numérica");
            return;
        }

        if(cliente == null || producto == null || cantidad <= 0) {
            showAlert("Error", "Debe seleccionar cliente, producto y cantidad válida");
            return;
        }

        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(producto, cantidad);

        cafeteria.agregarPedido(pedido);
        listaPedidos.add(pedido);

        txtCantidad.clear();
    }

    @FXML
    private void eliminarPedido() {
        Pedido seleccionado = tablePedidos.getSelectionModel().getSelectedItem();
        if(seleccionado != null) {
            cafeteria.eliminarPedido(seleccionado);
            listaPedidos.remove(seleccionado);
        } else {
            showAlert("Error", "Debe seleccionar un pedido");
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

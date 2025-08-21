package co.edu.uniquindio.poo.cafeteria.viewController;

import co.edu.uniquindio.poo.cafeteria.App;
import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.DescuentoCantidad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DescuentoViewController {

    private App app;
    private Cafeteria cafeteria = App.cafeteria;

    @FXML private TableView<DescuentoCantidad.NivelDescuento> tableDescuentos;
    @FXML private TableColumn<DescuentoCantidad.NivelDescuento, Integer> colCantidad;
    @FXML private TableColumn<DescuentoCantidad.NivelDescuento, Double> colPorcentaje;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtPorcentaje;
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    private ObservableList<DescuentoCantidad.NivelDescuento> listaDescuentos;
    private DescuentoCantidad descuentoCantidad = new DescuentoCantidad();

    public void setApp(App app) {
        this.app = app;
        cargarDescuentos();
    }

    @FXML
    private void initialize() {
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidadMinima"));
        colPorcentaje.setCellValueFactory(new PropertyValueFactory<>("porcentajeDescuento"));
    }

    private void cargarDescuentos() {
        listaDescuentos = FXCollections.observableArrayList(descuentoCantidad.getNiveles());
        tableDescuentos.setItems(listaDescuentos);
    }

    @FXML
    private void agregarDescuento() {
        int cantidad;
        double porcentaje;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
            porcentaje = Double.parseDouble(txtPorcentaje.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Cantidad y porcentaje deben ser numéricos");
            return;
        }

        descuentoCantidad.agregarNivelDescuento(cantidad, porcentaje, "Descuento Personalizado");
        listaDescuentos.setAll(descuentoCantidad.getNiveles());
        txtCantidad.clear();
        txtPorcentaje.clear();
    }

    @FXML
    private void eliminarDescuento() {
        DescuentoCantidad.NivelDescuento seleccionado = tableDescuentos.getSelectionModel().getSelectedItem();
        if(seleccionado != null) {
            descuentoCantidad.getNiveles().remove(seleccionado);
            listaDescuentos.setAll(descuentoCantidad.getNiveles());
        } else {
            showAlert("Error", "Debe seleccionar un nivel de descuento");
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

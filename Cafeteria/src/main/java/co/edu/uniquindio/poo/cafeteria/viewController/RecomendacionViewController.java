package co.edu.uniquindio.poo.cafeteria.viewController;

import co.edu.uniquindio.poo.cafeteria.App;
import co.edu.uniquindio.poo.cafeteria.model.Cafeteria;
import co.edu.uniquindio.poo.cafeteria.model.Recomendacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RecomendacionViewController {

    private App app;
    private Cafeteria cafeteria = App.cafeteria;

    @FXML private TableView<Recomendacion> tableRecomendaciones;
    @FXML private TableColumn<Recomendacion, String> colMensaje;
    @FXML private TextField txtMensaje;
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    private ObservableList<Recomendacion> listaRecomendaciones;

    public void setApp(App app) {
        this.app = app;
        cargarRecomendaciones();
    }

    @FXML
    private void initialize() {
        colMensaje.setCellValueFactory(data -> data.getValue().mensajeProperty());
    }

    private void cargarRecomendaciones() {
        listaRecomendaciones = FXCollections.observableArrayList(cafeteria.getRecomendaciones());
        tableRecomendaciones.setItems(listaRecomendaciones);
    }

    @FXML
    private void agregarRecomendacion() {
        String mensaje = txtMensaje.getText();
        if(mensaje.isEmpty()) {
            showAlert("Error", "Debe escribir un mensaje");
            return;
        }
        Recomendacion rec = new Recomendacion(mensaje);
        cafeteria.agregarRecomendacion(rec);
        listaRecomendaciones.add(rec);
        txtMensaje.clear();
    }

    @FXML
    private void eliminarRecomendacion() {
        Recomendacion seleccionado = tableRecomendaciones.getSelectionModel().getSelectedItem();
        if(seleccionado != null) {
            cafeteria.eliminarRecomendacion(seleccionado);
            listaRecomendaciones.remove(seleccionado);
        } else {
            showAlert("Error", "Debe seleccionar una recomendación");
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

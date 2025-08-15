package co.edu.uniquindio.poo.veterinaria.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.veterinaria.App;
import co.edu.uniquindio.poo.veterinaria.controller.PropietarioController;
import co.edu.uniquindio.poo.veterinaria.model.Propietario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PropietarioViewController {

    PropietarioController propietarioController;
    ObservableList<Propietario> listPropietarios = FXCollections.observableArrayList();
    Propietario selectedPropietario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Propietario> tblListPropietario;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarPropietario;

    @FXML
    private TableColumn<Propietario, String> tbcNombre;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TableColumn<Propietario, String> tbcIdentificacion;

    @FXML
    private Button btbAgregarPropietario;

    @FXML
    private TableColumn<Propietario, String> tbcTelefono;

    @FXML
    private TextField txtTelefono;


    @FXML
    private TableColumn<Propietario, String> tbcDireccion;

    @FXML
    private TextField txtDireccion;
    private App app;

    @FXML
    void onAgregarPropietario() {
        agregarPropietario();
    }

    @FXML
    void onActualizarPropietario() {
        actualizarPropietario();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarPropietario();
    }

    @FXML
    void initialize() {
        this.app=app;
        propietarioController = new PropietarioController(app.veterinaria);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerPropietarios();

        // Limpiar la tabla
        tblListPropietario.getItems().clear();

        // Agregar los elementos a la tabla
        tblListPropietario.setItems(listPropietarios);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tbcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerPropietarios() {
        listPropietarios.addAll(propietarioController.obtenerListaPropietarios());
    }

    private void listenerSelection() {
        tblListPropietario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPropietario = newSelection;
            mostrarInformacionPropietario(selectedPropietario);
        });
    }

    private void mostrarInformacionPropietario(Propietario propietario) {
        if (propietario != null) {
            txtNombre.setText(propietario.getNombre());
            txtIdentificacion.setText(propietario.getIdentificacion());
            txtTelefono.setText(propietario.getTelefono());
            txtDireccion.setText(propietario.getDireccion());
        }
    }

    private void agregarPropietario() {
        Propietario propietario = buildPropietario();
        if (propietarioController.crearPropietario(propietario)) {
            listPropietarios.add(propietario);
            limpiarCamposPropietario();
        }
    }

    private Propietario buildPropietario() {
        Propietario propietario = new Propietario(txtNombre.getText(), txtIdentificacion.getText(), txtTelefono.getText(), txtDireccion.getText());
        return propietario;
    }

    private void eliminarPropietario() {
        if (propietarioController.eliminarPropietario(txtIdentificacion.getText())) {
            listPropietarios.remove(selectedPropietario);
            limpiarCamposPropietario();
            limpiarSeleccion();
        }
    }

    private void actualizarPropietario() {

        if (selectedPropietario != null &&
                propietarioController.actualizarPropietario(selectedPropietario.getIdentificacion(), buildPropietario())) {

            int index = listPropietarios.indexOf(selectedPropietario);
            if (index >= 0) {
                listPropietarios.set(index, buildPropietario());
            }

            tblListPropietario.refresh();
            limpiarSeleccion();
            limpiarCamposPropietario();
        }
    }

    private void limpiarSeleccion() {
        tblListPropietario.getSelectionModel().clearSelection();
        limpiarCamposPropietario();
    }

    private void limpiarCamposPropietario() {
        txtNombre.clear();
        txtIdentificacion.clear();
        txtTelefono.clear();
        txtDireccion.clear();

    }

    public void setApp(App app) {
        this.app = app;
    }
}

package co.edu.uniquindio.poo.veterinaria.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.veterinaria.App;
import co.edu.uniquindio.poo.veterinaria.controller.VeterinarioController;
import co.edu.uniquindio.poo.veterinaria.model.Veterinario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VeterinarioViewController {

    VeterinarioController veterinarioController;
    ObservableList<Veterinario> listVeterinarios = FXCollections.observableArrayList();
    Veterinario selectedVeterinario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Veterinario> tblListVeterinarios;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarVeterinario;

    @FXML
    private TableColumn<Veterinario, String> tbcNombre;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TableColumn<Veterinario, String> tbcIdentificacion;

    @FXML
    private Button btbAgregarVeterinario;

    @FXML
    private TableColumn<Veterinario, String> tbcTelefono;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TableColumn<Veterinario, String> tbcDireccion;
    @FXML
    private TextField txtDireccion;

    @FXML
    private TableColumn<Veterinario, String> tbcLicenciaProfesional;
    @FXML
    private TextField txtLicenciaProfesional;

    @FXML
    private TableColumn<Veterinario, String> tbcEspecialidad;
    @FXML
    private TextField txtEspecialidad;
    private App app;

    @FXML
    void onAgregarVeterinario() {
        agregarVeterinario();
    }

    @FXML
    void onActualizarVeterinario() {
        actualizarVeterinario();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }
    @FXML
    void onEliminar() {
        eliminarVeterinario();
    }


    @FXML
    void initialize() {
        this.app=app;
        veterinarioController = new VeterinarioController(app.veterinaria);
        initView();
    }

    private void initView() {
        // Traer los datos del veterinario a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerVeterinarios();

        // Limpiar la tabla
        tblListVeterinarios.getItems().clear();

        // Agregar los elementos a la tabla
        tblListVeterinarios.setItems(listVeterinarios);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tbcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tbcLicenciaProfesional.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLicenciaProfesional()));
        tbcEspecialidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecialidad()));


        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerVeterinarios() {
        listVeterinarios.addAll(veterinarioController.obtenerListaVeterinarios());
    }

    private void listenerSelection() {
        tblListVeterinarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVeterinario = newSelection;
            mostrarInformacionVeterinario(selectedVeterinario);
        });
    }

    private void mostrarInformacionVeterinario(Veterinario veterinario) {
        if (veterinario != null) {
            txtIdentificacion.setText(veterinario.getIdentificacion());
            txtNombre.setText(veterinario.getNombre());
            txtTelefono.setText(veterinario.getTelefono());
            txtDireccion.setText(veterinario.getDireccion());
            txtLicenciaProfesional.setText(veterinario.getLicenciaProfesional());
            txtEspecialidad.setText(veterinario.getEspecialidad());
        }
    }

    private void agregarVeterinario() {
        Veterinario veterinario = buildVeterinario();
        if (veterinarioController.crearVeterinario(veterinario)) {
            listVeterinarios.add(veterinario);
            limpiarCamposVeterinarios();
        }
    }

    private Veterinario buildVeterinario() {
        Veterinario veterinario = new Veterinario(txtNombre.getText(), txtIdentificacion.getText(), txtTelefono.getText(), txtDireccion.getText(), txtLicenciaProfesional.getText(), txtEspecialidad.getText());
        return veterinario;
    }

    private void actualizarVeterinario() {

        if (selectedVeterinario != null &&
                veterinarioController.actualizarVeterinario(selectedVeterinario.getIdentificacion(), buildVeterinario())) {

            int index = listVeterinarios.indexOf(selectedVeterinario);
            if (index >= 0) {
                listVeterinarios.set(index, buildVeterinario());
            }

            tblListVeterinarios.refresh();
            limpiarSeleccion();
            limpiarCamposVeterinarios();
        }
    }
    private void eliminarVeterinario() {
        if (veterinarioController.eliminarVeterinario(txtIdentificacion.getText())) {
            listVeterinarios.remove(selectedVeterinario);
            limpiarCamposVeterinarios();
            limpiarSeleccion();
        }
    }


    private void limpiarSeleccion() {
        tblListVeterinarios.getSelectionModel().clearSelection();
        limpiarCamposVeterinarios();
    }

    private void limpiarCamposVeterinarios() {
        txtNombre.clear();
        txtIdentificacion.clear();
        txtTelefono.clear();
        txtDireccion.clear();
        txtLicenciaProfesional.clear();
        txtEspecialidad.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}


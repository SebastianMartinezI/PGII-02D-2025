package co.edu.uniquindio.poo.veterinaria.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.veterinaria.App;
import co.edu.uniquindio.poo.veterinaria.controller.MascotaController;
import co.edu.uniquindio.poo.veterinaria.model.Mascota;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MascotaViewController {

    MascotaController mascotaController;
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    Mascota selectedMascota;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Mascota> tblListMascota;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private TableColumn<Mascota, String> tbcNombre;

    @FXML
    private TextField txtEspecie;

    @FXML
    private TableColumn<Mascota, String> tbcEspecie;

    @FXML
    private Button btbAgregarCliente;

    @FXML
    private TextField txtEdad;

    @FXML
    private TableColumn<Mascota, String> tbcEdad;

    @FXML
    private TextField txtIdentificacionVeterinaria;

    @FXML
    private TableColumn<Mascota, String> tbcIdentificacionVeterinaria;

    @FXML
    private TextField txtPropietario;

    @FXML
    private TableColumn<Mascota, String> tbcPropietario;

    @FXML
    private TableColumn<Mascota, String> tbcRaza;

    @FXML
    private TextField txtRaza;
    private App app;

    @FXML
    void onAgregarMascota() {
        agregarMascota();
    }

    @FXML
    void onActualizarMascota() {
        actualizarMascota();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarMascota();
    }

    @FXML
    void initialize() {
        this.app=app;
        mascotaController = new MascotaController(app.veterinaria);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerMascotas();

        // Limpiar la tabla
        tblListMascota.getItems().clear();

        // Agregar los elementos a la tabla
        tblListMascota.setItems(listMascotas);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcEspecie.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecie()));
        tbcRaza.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRaza()));
        tbcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEdad()));
        tbcIdentificacionVeterinaria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacionVeterinaria()));
        tbcPropietario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPropietario()));



        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerMascotas() {
        listMascotas.addAll(mascotaController.obtenerListaMascotas());
    }

    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMascota = newSelection;
            mostrarInformacionMascota(selectedMascota);
        });
    }

    private void mostrarInformacionMascota(Mascota mascota) {
        if (mascota != null) {
            txtNombre.setText(mascota.getNombre());
            txtEspecie.setText(mascota.getEspecie());
            txtRaza.setText(mascota.getRaza());
            txtEdad.setText(mascota.getEdad());
            txtIdentificacionVeterinaria.setText(mascota.getIdentificacionVeterinaria());
            txtPropietario.setText(mascota.getPropietario());
        }
    }

    private void agregarMascota() {
        Mascota mascota = buildMascota();
        if (mascotaController.crearMascota(mascota)) {
            listMascotas.add(mascota);
            limpiarCamposMascota();
        }
    }

    private Mascota buildMascota() {
        Mascota mascota = new Mascota(txtNombre.getText(), txtEspecie.getText(), txtRaza.getText(), txtEdad.getText(),txtIdentificacionVeterinaria.getText(),txtPropietario.getText());
        return mascota;
    }

    private void eliminarMascota() {
        if (mascotaController.eliminarMascota(txtIdentificacionVeterinaria.getText())) {
            listMascotas.remove(selectedMascota);
            limpiarCamposMascota();
            limpiarSeleccion();
        }
    }

    private void actualizarMascota() {

        if (selectedMascota != null &&
                mascotaController.actualizarMascota(selectedMascota.getIdentificacionVeterinaria(), buildMascota())) {

            int index = listMascotas.indexOf(selectedMascota);
            if (index >= 0) {
                listMascotas.set(index, buildMascota());
            }

            tblListMascota.refresh();
            limpiarSeleccion();
            limpiarCamposMascota();
        }
    }

    private void limpiarSeleccion() {
        tblListMascota.getSelectionModel().clearSelection();
        limpiarCamposMascota();
    }

    private void limpiarCamposMascota() {
        txtNombre.clear();
        txtEspecie.clear();
        txtRaza.clear();
        txtEdad.clear();
        txtIdentificacionVeterinaria.clear();
        txtPropietario.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}

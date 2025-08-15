package co.edu.uniquindio.poo.veterinaria.viewController;

import co.edu.uniquindio.poo.veterinaria.App;
import co.edu.uniquindio.poo.veterinaria.controller.ConsultaController;
import co.edu.uniquindio.poo.veterinaria.controller.MascotaController;
import co.edu.uniquindio.poo.veterinaria.model.Consulta;
import co.edu.uniquindio.poo.veterinaria.model.Mascota;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultaViewController {

    ConsultaController consultaController;
    ObservableList<Consulta> listConsultas = FXCollections.observableArrayList();
    Consulta selectedConsulta;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtMotivo;

    @FXML
    private TextField txtDiagnostico;

    @FXML
    private TextField txtMascota;
    @FXML
    private TextField getTxtDiagnostico;

    @FXML
    private TextField txtVeterinario;
    private App app;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Consulta> tblListConsultas;

    @FXML
    private TableColumn<Consulta, String> tbcFecha;

    @FXML
    private TableColumn<Consulta, String> tbcHora;

    @FXML
    private TableColumn<Consulta, String> tbcMascota;

    @FXML
    private TableColumn<Consulta, String> tbcVeterinario;

    @FXML
    private TableColumn<Consulta, String> tbcMotivo;

    @FXML
    private TableColumn<Consulta, String> tbcDiagnostico;

    @FXML
    void onAgregarConsulta() {
        agregarConsulta();
    }

    @FXML
    void initialize() {
        this.app = app; // Obtiene la instancia única de App
        this.consultaController = new ConsultaController(app.veterinaria);
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerConsultas();
        tblListConsultas.getItems().clear();
        tblListConsultas.setItems(listConsultas);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
        tbcHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHora()));
        tbcMascota.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMascota()));
        tbcVeterinario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVeterinario()));
        tbcMotivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivoConsulta()));
        tbcDiagnostico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnostico()));

    }

    private void obtenerConsultas() {
        listConsultas.addAll(consultaController.obtenerListConsulta());
    }

    private void listenerSelection() {
        tblListConsultas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedConsulta = newSelection;
            mostrarInformacionConsulta(selectedConsulta);
        });
    }

    private void mostrarInformacionConsulta(Consulta consulta) {
        if (consulta != null) {
            txtFecha.setText(consulta.getFecha());
            txtHora.setText(consulta.getHora());
            txtMascota.setText(consulta.getMascota());
            txtVeterinario.setText(consulta.getVeterinario());
            txtMotivo.setText(consulta.getMotivoConsulta());
            txtDiagnostico.setText(consulta.getDiagnostico());
        }
    }

    private void agregarConsulta() {
        Consulta consulta = buildConsulta();
        if (consultaController.crearConsulta(consulta)) {
            listConsultas.add(consulta);
            limpiarCamposConsulta();
        }
    }

    private Consulta buildConsulta() {
        Consulta consulta = new Consulta(txtFecha.getText(), txtHora.getText(), txtMascota.getText(), txtVeterinario.getText(),txtMotivo.getText(),txtDiagnostico.getText());
        return consulta;
    }

    private void limpiarCamposConsulta() {
        txtFecha.clear();
        txtHora.clear();
        txtMascota.clear();
        txtVeterinario.clear();
        txtMotivo.clear();
        txtDiagnostico.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
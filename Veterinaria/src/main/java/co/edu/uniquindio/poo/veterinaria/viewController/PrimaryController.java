package co.edu.uniquindio.poo.veterinaria.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.veterinaria.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;


    @FXML
    private Button mascotaButton;

    @FXML
    void onOpenCrudMascota() {
        app.openCrudMascota();
    }

    @FXML
    private Button consultaButton;

    @FXML
    void onOpenCrudConsulta() {app.openCrudConsulta();
    }


    @FXML
    private Button veterinarioButton;
    @FXML
    void onOpenCrudVeterinario() {
        app.openCrudVeterinario();
    }

    @FXML
    private Button propietarioButton;

    @FXML
    void onOpenCrudPropietario() {
        app.openCrudPropietario();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }
}
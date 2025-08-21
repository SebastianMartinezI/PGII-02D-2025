package co.edu.uniquindio.poo.cafeteria.viewController;

import co.edu.uniquindio.poo.cafeteria.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController {

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private void abrirClientes(ActionEvent event) {
        app.openCrudClientes();
    }

    @FXML
    private void abrirProductos(ActionEvent event) {
        app.openCrudProductos();
    }

    @FXML
    private void abrirPedidos(ActionEvent event) {
        app.openCrudPedidos();
    }

    @FXML
    private void abrirDescuentos(ActionEvent event) {
        app.openGestionDescuentos();
    }

    @FXML
    private void abrirRecomendaciones(ActionEvent event) {
        app.openGestionRecomendaciones();
    }
}

package co.edu.uniquindio.poo.veterinaria;
import co.edu.uniquindio.poo.veterinaria.model.*;
import co.edu.uniquindio.poo.veterinaria.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    public static Veterinaria veterinaria = new Veterinaria("Colitas", "VIlla Liliana", 7322222);

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Propietarios");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openCrudPropietario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudPropietario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PropietarioViewController propietarioViewController = loader.getController();
            propietarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudMascota() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudMascota.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MascotaViewController mascotaViewController = loader.getController();
            mascotaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudVeterinario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudVeterinario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VeterinarioViewController veterinarioViewController = loader.getController();
            veterinarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudConsulta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudConsulta.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ConsultaViewController consultaViewController = loader.getController();
            consultaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //servicios
    public void inicializarData() {
        Propietario propietario = new Propietario("Juan", "1111", "30202222", "7 de Agosto");
        veterinaria.agregarPropietario(propietario);

        Mascota mascota = new Mascota("Pepe", "Félino", "pincher", "7", "1122", "Juan");
        veterinaria.agregarMascota(mascota);

        Veterinario veterinario = new Veterinario("Juan", "1111", "30202222", "7 de Agosto", "1234", "Roedores");
        veterinaria.agregarVeterinario(veterinario);

        Consulta consulta = new Consulta("Abril", "11:11", "Lula", "Juan", "Dolor", "Reservado", "Acetaminofén");
        veterinaria.agregarConsulta(consulta);
    }
}
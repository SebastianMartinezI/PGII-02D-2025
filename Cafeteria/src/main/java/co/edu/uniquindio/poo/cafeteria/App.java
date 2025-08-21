package co.edu.uniquindio.poo.cafeteria;

import co.edu.uniquindio.poo.cafeteria.model.*;
import co.edu.uniquindio.poo.cafeteria.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App para la gestión de la cafetería
 */
public class App extends Application {

    private Stage primaryStage;
    public static Cafeteria cafeteria = new Cafeteria();

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión de Cafetería");
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
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    // ------------------- CRUDS -------------------
    public void openCrudClientes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCliente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ClienteViewController clienteController = loader.getController();
            clienteController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCrudProductos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudProducto.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ProductoViewController productoController = loader.getController();
            productoController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCrudPedidos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudPedido.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PedidoViewController pedidoController = loader.getController();
            pedidoController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openGestionDescuentos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("descuentoView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DescuentoViewController descuentoController = loader.getController();
            descuentoController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openGestionRecomendaciones() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("recomendacionView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RecomendacionViewController recomendacionController = loader.getController();
            recomendacionController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------- SERVICIOS -------------------
    public void inicializarData() {
        // Clientes de ejemplo
        Cliente estudiante = new Estudiante("Juan", "1111","02-D","Sistemas", 3);
        cafeteria.agregarCliente(estudiante);

        Cliente docente = new Docente("Ana", "2222", "123", "Quindio", "Especializado");
        cafeteria.agregarCliente(docente);
        cafeteria.agregarCliente(estudiante);

        // Productos de ejemplo
        Producto cafe = new Bebida(111,"Café", 5000, "Americano",true,"grande",true);
        Producto te = new Bebida(222,"té", 5000, "limon",true,"grande",false);

        Producto torta = new Comida(333, "Torta de Chocolate", 12000,"Chocolate", true,"Pasteles", 5);
        cafeteria.agregarProducto(cafe);
        cafeteria.agregarProducto(te);
        cafeteria.agregarProducto(torta);

        // Descuentos de ejemplo
        DescuentoHoraFeliz descuentoHora = new DescuentoHoraFeliz();
        DescuentoCantidad descuentoCantidad = new DescuentoCantidad();
        cafeteria.agregarEstrategiaDescuento(descuentoHora);
        cafeteria.agregarEstrategiaDescuento(descuentoCantidad);

    }
}

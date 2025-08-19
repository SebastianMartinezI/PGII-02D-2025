module co.edu.uniquindio.poo.cafeteria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens co.edu.uniquindio.poo.cafeteria to javafx.fxml;
    exports co.edu.uniquindio.poo.cafeteria;
    exports co.edu.uniquindio.poo.cafeteria.viewController;
    opens co.edu.uniquindio.poo.cafeteria.viewController to javafx.fxml;

}

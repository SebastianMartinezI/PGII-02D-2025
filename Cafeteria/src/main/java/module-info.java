module co.edu.uniquindio.poo.cafeteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.cafeteria to javafx.fxml;
    exports co.edu.uniquindio.poo.cafeteria;
}
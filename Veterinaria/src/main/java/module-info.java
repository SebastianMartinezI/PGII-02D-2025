module co.edu.uniquindio.poo.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.veterinaria to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinaria;
    exports co.edu.uniquindio.poo.veterinaria.viewController;
    opens co.edu.uniquindio.poo.veterinaria.viewController to javafx.fxml;

}

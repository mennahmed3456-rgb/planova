module com.example.planova {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.planova to javafx.fxml;
    exports com.example.planova;
    exports com.example.planova.controllers;
    opens com.example.planova.controllers to javafx.fxml;
    exports com.example.planova.views;
    opens com.example.planova.views to javafx.fxml;
}
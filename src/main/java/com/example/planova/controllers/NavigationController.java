//package com.example.planova.controllers;
//
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class NavigationController {
//
//    private Stage stage;
//
//    public NavigationController(Stage stage) {
//        this.stage = stage;
//    }
//
//    public void goTo(Scene scene) {
//        stage.setScene(scene);
//    }
//
//    public Stage getStage() {
//        return stage;
//    }
//}


package com.example.planova.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NavigationController {

    private Stage stage;

    public NavigationController(Stage stage) {
        this.stage = stage;
    }

    public void goTo(Parent view) {
        Scene scene = new Scene(view, 1200, 700);
        stage.setScene(scene);
    }

    public Stage getStage() {
        return stage;
    }
}
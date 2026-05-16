package com.example.planova;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        DashboardPage dashboard = new DashboardPage();

        stage.setTitle("Planova");

        stage.setScene(dashboard.createScene());

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
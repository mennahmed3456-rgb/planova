package com.example.planova.controllers;

import com.example.planova.views.DashboardView;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class HomeController {


    public Scene getScene() {
        StackPane root = new StackPane();

        Label label = new Label("Home Page");
        label.setFont(Font.font(24));

        root.getChildren().add(label);

        return new Scene(root, 1200, 800);
    }
}
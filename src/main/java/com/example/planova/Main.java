package com.example.planova;

import com.example.planova.controllers.NavigationController;
import com.example.planova.views.AnalyticsView;
import com.example.planova.views.LoginView;
import com.example.planova.views.PlansView;
import com.example.planova.views.TasksView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        NavigationController nav = new NavigationController(stage);

        LoginView loginView = new LoginView(nav);

        Scene scene = new Scene(loginView.getView(), 1200, 700);
        //TasksView TasksView = new TasksView(nav);

        //Scene scene = new Scene(TasksView.getView(), 1200, 700);

        stage.setScene(scene);
        stage.setTitle("PlanNova");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
//package com.example.planova.controllers;
//
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.scene.control.Label;
//import javafx.scene.text.Font;
//
//public class TasksController {
//
//    public TasksController(NavigationController navigationController) {
//
//    }
//
//    public Scene getScene() {
//        StackPane root = new StackPane();
//
//        Label label = new Label("Tasks Page");
//        label.setFont(Font.font(24));
//
//        root.getChildren().add(label);
//
//        return new Scene(root, 1200, 800);
//    }
//}

package com.example.planova.controllers;

import com.example.planova.views.TasksView;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class TasksController {

    private TasksView view;

    public TasksController(NavigationController navigationController) {
        this.view = new TasksView(navigationController);
    }

    public Parent getView() {
        return view.getView();
    }
}
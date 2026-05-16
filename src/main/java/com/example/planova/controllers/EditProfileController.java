package com.example.planova.controllers;

import com.example.planova.views.EditProfileView;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EditProfileController {

    private NavigationController navigationController;
    private EditProfileView view;

    public EditProfileController(NavigationController nav) {
        this.navigationController = nav;
        this.view = new EditProfileView(nav);
    }
    public Parent getView() {
        return view.getView();
    }

    public Scene getScene() {
        return new Scene(view.getView(), 1200, 800);
    }
}
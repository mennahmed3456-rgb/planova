package com.example.planova.controllers;

import com.example.planova.views.DashboardView;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DashboardController {

    private DashboardView view;

    public DashboardController(NavigationController nav) {
        view = new DashboardView(nav);
    }
    public Parent getView() {
        return view.getView();
    }

}
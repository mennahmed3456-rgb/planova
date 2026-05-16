package com.example.planova.controllers;

import com.example.planova.views.AnalyticsView;
import javafx.scene.Parent;

public class AnalyticsController {

    private AnalyticsView view;

    public AnalyticsController(NavigationController navigationController) {
        this.view = new AnalyticsView(navigationController);
    }

    public Parent getView() {
        return view.getView();
    }
}
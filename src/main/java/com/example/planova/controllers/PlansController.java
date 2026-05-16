//package com.example.planova.controllers;
//
//import com.example.planova.views.PlansView;
//import javafx.scene.Parent;
//
//public class PlansController {
//
//    private PlansView view;
//
//    public PlansController(NavigationController nav) {
//        view = new PlansView(nav);
//    }
//
//    public Parent getView() {
//        return view.getView();
//    }
//}
package com.example.planova.controllers;

import com.example.planova.models.WeeklyPlan;
import com.example.planova.views.NewPlanView;
import com.example.planova.views.PlansView;
import com.example.planova.data.AppData;
import javafx.scene.Parent;

public class PlansController {

    private PlansView view;

    public PlansController(NavigationController nav) {
        this.view = new PlansView(nav);
    }

    public Parent getView() {
        return view.getView();
    }

    /**
     * Opens the New Plan creation screen
     */
    public void createNewPlan(NavigationController nav) {
        nav.goTo(new NewPlanView(nav).getView());
    }

    /**
     * Returns the currently active plan (if any)
     */
    public static WeeklyPlan getCurrentPlan() {
        return AppData.currentPlan;
    }

    /**
     * Saves a new plan to AppData
     */
    public static void savePlan(WeeklyPlan plan) {
        if (plan != null) {
            AppData.weeklyPlans.add(plan);
            AppData.currentPlan = plan;
        }
    }
}
//package com.example.planova.controllers;
//
//import com.example.planova.views.SettingsView;
//import javafx.scene.Parent;
//
//public class SettingsController {
//
//    private SettingsView settingsView;
//
//    public SettingsController(NavigationController nav) {
//        this.settingsView = new SettingsView(nav);
//    }
//    public Parent getView() {
//        return settingsView.getView();
//    }
//
//
//}

package com.example.planova.controllers;

import com.example.planova.data.AppData;
import com.example.planova.views.LoginView;
import com.example.planova.views.SettingsView;
import javafx.scene.Parent;
import javafx.scene.control.*;

public class SettingsController {

    private SettingsView settingsView;
    private NavigationController nav;

    // Controls from the view (سنربطها)
    private CheckBox darkModeCheck;
    private CheckBox compactModeCheck;
    private CheckBox emailNotifCheck;
    private CheckBox pushNotifCheck;
    private CheckBox weeklyReportCheck;
    private ComboBox<String> focusModeCombo;
    private Spinner<Integer> startTimeSpinner;

    public SettingsController(NavigationController nav) {
        this.nav = nav;
        this.settingsView = new SettingsView(nav);

        // ربط الـ Controls من الـ View
        this.settingsView.setController(this);   // مهم
    }

    public Parent getView() {
        return settingsView.getView();
    }

    /**
     * يتم استدعاؤه من SettingsView بعد إنشاء الـ UI
     */
    public void setControls(
            CheckBox darkMode,
            CheckBox compactMode,
            CheckBox emailNotif,
            CheckBox pushNotif,
            CheckBox weeklyReport,
            ComboBox<String> focusMode,
            Spinner<Integer> startTime) {

        this.darkModeCheck = darkMode;
        this.compactModeCheck = compactMode;
        this.emailNotifCheck = emailNotif;
        this.pushNotifCheck = pushNotif;
        this.weeklyReportCheck = weeklyReport;
        this.focusModeCombo = focusMode;
        this.startTimeSpinner = startTime;
    }

    /**
     * حفظ الإعدادات
     */
    public void saveSettings() {
        if (darkModeCheck == null) return;

        // هنا يمكنك حفظ في AppData أو ملف لاحقاً
        System.out.println("=== Settings Saved ===");
        System.out.println("Dark Mode: " + darkModeCheck.isSelected());
        System.out.println("Compact Mode: " + compactModeCheck.isSelected());
        System.out.println("Email Notifications: " + emailNotifCheck.isSelected());
        System.out.println("Push Notifications: " + pushNotifCheck.isSelected());
        System.out.println("Weekly Report: " + weeklyReportCheck.isSelected());
        System.out.println("Default Focus Mode: " + focusModeCombo.getValue());
        System.out.println("Work Start Reminder: " + startTimeSpinner.getValue() + ":00");

        // يمكنك هنا حفظ في AppData لاحقاً
        // AppData.settings.setDarkMode(darkModeCheck.isSelected()); ...

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Settings saved successfully!");
        alert.showAndWait();
    }

    /**
     * Logout
     */
    public void logout() {
        nav.goTo(new LoginView(nav).getView());
    }
}
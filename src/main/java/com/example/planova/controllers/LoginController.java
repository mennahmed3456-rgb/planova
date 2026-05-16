//package com.example.planova.controllers;
//
//import com.example.planova.data.AppData;
//import com.example.planova.models.User;
//
//public class LoginController {
//
//    private static User currentUser;
//
//    public boolean login(String email, String password) {
//
//        for (User user : AppData.users) {
//
//            if (user.getEmail().equals(email)
//                    && user.getPassword().equals(password)) {
//
//                currentUser = user;
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static User getCurrentUser() {
//        return currentUser;
//    }
//
//    public static void logout() {
//        currentUser = null;
//    }
//}

package com.example.planova.controllers;

import com.example.planova.data.AppData;
import com.example.planova.models.User;
import com.example.planova.views.SetupView;

import javafx.scene.control.Alert;

public class LoginController {

    private NavigationController nav;

    private static User currentUser;

    public LoginController(NavigationController nav) {

        this.nav = nav;
    }

    public void handleLogin(String email, String password) {

        if (email.isEmpty() || password.isEmpty()) {

            showError(
                    "Please fill all fields"
            );

            return;
        }

        boolean success = login(email, password);

        if (success) {

            nav.goTo(
                    new SetupView(nav).getView()
            );

        } else {

            showError(
                    "Invalid Email or Password"
            );
        }
    }

    private boolean login(String email, String password) {

        for (User user : AppData.users) {

            if (user.getEmail().equals(email)
                    && user.getPassword().equals(password)) {

                currentUser = user;

                return true;
            }
        }

        return false;
    }

    private void showError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.show();
    }

    public static User getCurrentUser() {

        return currentUser;
    }

    public static void logout() {

        currentUser = null;
    }
}
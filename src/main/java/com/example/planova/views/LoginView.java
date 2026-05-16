//package com.example.planova.views;
//
//import com.example.planova.controllers.LoginController;
//import com.example.planova.controllers.NavigationController;
//import com.example.planova.styles.AppColors;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//
//public class LoginView {
//
//    private VBox root;
//    private LoginController controller;
//    private NavigationController nav;
//
//    public LoginView(NavigationController nav) {
//        this.nav = nav;
//        this.controller = new LoginController();
//        createUI();
//    }
//
//    public Parent getView() {
//        return root;
//    }
//
//    private void createUI() {
//
//        root = new VBox();
//        root.setAlignment(Pos.CENTER);
//
//        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        VBox card = new VBox(15);
//        card.setPadding(new Insets(40));
//        card.setMaxWidth(420);
//        card.setAlignment(Pos.CENTER_LEFT);
//
//        card.setStyle("-fx-background-color: " + AppColors.CARD + ";"
//                + "-fx-background-radius: 20;");
//
//        Label title = new Label("Welcome back");
//        title.setFont(Font.font(24));
//        title.setTextFill(Color.WHITE);
//
//        TextField email = new TextField();
//        email.setPromptText("Email");
//
//        PasswordField password = new PasswordField();
//        password.setPromptText("Password");
//
//        Button loginBtn = new Button("Login");
//
//        loginBtn.setOnAction(e -> {
//
//            boolean success = controller.login(
//                    email.getText(),
//                    password.getText()
//            );
//
//            if (success) {
//
//                nav.goTo(
//                        new SetupView(nav).getView()
//                );
//
//            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Invalid Email or Password");
//                alert.show();
//            }
//        });
//
//        Hyperlink register = new Hyperlink("Create account");
//
//        register.setOnAction(e ->
//                nav.goTo(new RegisterView(nav).getView())
//        );
//
//        card.getChildren().addAll(
//                title,
//                email,
//                password,
//                loginBtn,
//                register
//        );
//
//        root.getChildren().add(card);
//    }
//}

package com.example.planova.views;

import com.example.planova.controllers.LoginController;
import com.example.planova.controllers.NavigationController;
import com.example.planova.styles.AppColors;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginView {

    private VBox root;

    private NavigationController nav;
    private LoginController controller;

    private TextField emailField;
    private PasswordField passwordField;

    private Button loginBtn;
    private Hyperlink registerLink;

    public LoginView(NavigationController nav) {

        this.nav = nav;
        this.controller = new LoginController(nav);

        createUI();
        setupActions();
    }

    public Parent getView() {
        return root;
    }

    private void createUI() {

        root = new VBox();

        root.setAlignment(Pos.CENTER);

        root.setStyle(
                "-fx-background-color: " + AppColors.BACKGROUND + ";"
        );

        VBox card = new VBox(15);

        card.setPadding(new Insets(40));

        card.setMaxWidth(420);

        card.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 20;"
        );

        //--------------------------------
        // Title
        //--------------------------------
        Label title = new Label("Welcome Back");

        title.setFont(Font.font(28));

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "Login to continue planning smarter"
        );

        subtitle.setTextFill(Color.web("#B0B3B8"));

        //--------------------------------
        // Email
        //--------------------------------
        Label emailLabel = new Label("Email");

        emailLabel.setTextFill(Color.WHITE);

        emailField = new TextField();

        emailField.setPromptText("Enter your email");

        styleField(emailField);

        //--------------------------------
        // Password
        //--------------------------------
        Label passLabel = new Label("Password");

        passLabel.setTextFill(Color.WHITE);

        passwordField = new PasswordField();

        passwordField.setPromptText("Enter password");

        styleField(passwordField);

        //--------------------------------
        // Login Button
        //--------------------------------
        loginBtn = new Button("Login");

        loginBtn.setPrefWidth(340);

        loginBtn.setPrefHeight(45);

        loginBtn.setStyle(
                "-fx-background-color: " + AppColors.PRIMARY + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-cursor: hand;"
        );

        //--------------------------------
        // Register Link
        //--------------------------------
        registerLink = new Hyperlink(
                "Don't have an account? Create Account"
        );

        registerLink.setTextFill(
                Color.web(AppColors.PRIMARY)
        );

        //--------------------------------
        // Add Nodes
        //--------------------------------
        card.getChildren().addAll(
                title,
                subtitle,

                emailLabel,
                emailField,

                passLabel,
                passwordField,

                loginBtn,
                registerLink
        );

        root.getChildren().add(card);
    }

    private void setupActions() {

        loginBtn.setOnAction(e -> handleLogin());

        registerLink.setOnAction(e ->
                nav.goTo(
                        new RegisterView(nav).getView()
                )
        );

        passwordField.setOnAction(e -> handleLogin());
    }

    private void handleLogin() {

        String email = emailField.getText().trim();

        String password = passwordField.getText().trim();

        controller.handleLogin(email, password);
    }

    private void styleField(TextField field) {

        field.setPrefHeight(42);

        field.setStyle(
                "-fx-background-color: " + AppColors.FIELD + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: gray;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-border-color: #30363D;"
        );
    }
}
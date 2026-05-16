package com.example.planova.views;

import com.example.planova.controllers.NavigationController;
import com.example.planova.controllers.RegisterController;
import com.example.planova.styles.AppColors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RegisterView {

    private VBox root;
    private RegisterController controller;
    private NavigationController nav;

    public RegisterView(NavigationController nav) {
        this.nav = nav;
        this.controller = new RegisterController();
        createUI();
    }

    public Parent getView() {
        return root;
    }

    private void createUI() {

        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

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
        Label title = new Label("Create Account");
        title.setFont(Font.font(28));
        title.setTextFill(Color.WHITE);

        //--------------------------------
        // Fields
        //--------------------------------
        Label nameLabel = new Label("Full Name");
        nameLabel.setTextFill(Color.WHITE);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        styleField(nameField);

        Label emailLabel = new Label("Email");
        emailLabel.setTextFill(Color.WHITE);

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        styleField(emailField);

        Label passLabel = new Label("Password");
        passLabel.setTextFill(Color.WHITE);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        styleField(passwordField);

        //--------------------------------
        // Register Button
        //--------------------------------
        Button registerBtn = new Button("Create Account");

        registerBtn.setPrefWidth(340);
        registerBtn.setPrefHeight(45);

        registerBtn.setStyle(
                "-fx-background-color: " + AppColors.PRIMARY + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14;" +
                        "-fx-background-radius: 10;"
        );

        registerBtn.setOnAction(e -> {

            boolean success = controller.register(
                    nameField.getText(),
                    emailField.getText(),
                    passwordField.getText()
            );

            Alert alert;

            if (success) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Account Created!");

                // optional: بعد التسجيل نرجع login
                alert.setOnHidden(ev ->
                        nav.goTo(new LoginView(nav).getView())
                );

            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Fill all fields");
            }

            alert.show();
        });

        //--------------------------------
        // Back to Login (FIXED)
        //--------------------------------
        Hyperlink loginLink = new Hyperlink("Already have an account? Login");
        loginLink.setTextFill(Color.web(AppColors.PRIMARY));

        loginLink.setOnAction(e ->
                nav.goTo(new LoginView(nav).getView())
        );

        //--------------------------------
        // Add Nodes
        //--------------------------------
        card.getChildren().addAll(
                title,

                nameLabel,
                nameField,

                emailLabel,
                emailField,

                passLabel,
                passwordField,

                registerBtn,
                loginLink
        );

        root.getChildren().add(card);
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
package com.example.planova.views;

import com.example.planova.controllers.NavigationController;
import com.example.planova.styles.AppColors;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EditProfileView {

    private ScrollPane root;
    private VBox content;

    private NavigationController nav;

    public EditProfileView(NavigationController nav) {
        this.nav = nav;
        createUI();
    }

    public Parent getView() {
        return root;
    }

    private void createUI() {

        //--------------------------------
        // CONTENT
        //--------------------------------
        content = new VBox(22);
        content.setPadding(new Insets(40, 70, 40, 70));
        content.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        //--------------------------------
        // SCROLL
        //--------------------------------
        root = new ScrollPane(content);
        root.setFitToWidth(true);

        root.setStyle(
                "-fx-background: " + AppColors.BACKGROUND + ";" +
                        "-fx-background-color: " + AppColors.BACKGROUND + ";"
        );

        //--------------------------------
        // TITLE
        //--------------------------------
        Label title = new Label("Edit Profile");
        title.setFont(Font.font("System", FontWeight.BOLD, 30));
        title.setTextFill(Color.WHITE);

        Label sub = new Label("Update your personal information");
        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        VBox header = new VBox(5, title, sub);

        //--------------------------------
        // CARD STYLE
        //--------------------------------
        String cardStyle =
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 18;";

        Insets pad = new Insets(18);

        //--------------------------------
        // PROFILE FORM
        //--------------------------------
        VBox formCard = new VBox(12);
        formCard.setPadding(pad);
        formCard.setStyle(cardStyle);

        Label nameLabel = sectionTitle("Name");
        TextField nameField = new TextField("Alex Johnson");

        Label emailLabel = sectionTitle("Email");
        TextField emailField = new TextField("alex@planova.app");

        Button saveBtn = primaryButton("Save Changes");

        saveBtn.setOnAction(e -> {
            // هنا ممكن تضيف save logic بعدين
            nav.goTo(new SettingsView(nav).getView());
        });

        formCard.getChildren().addAll(
                nameLabel,
                nameField,
                emailLabel,
                emailField,
                saveBtn
        );

        //--------------------------------
        // ADD ALL
        //--------------------------------
        content.getChildren().addAll(
                header,
                formCard
        );
    }

    //================================================
    // HELPERS
    //================================================

    private Label sectionTitle(String text) {
        Label l = new Label(text);
        l.setTextFill(Color.WHITE);
        l.setFont(Font.font("System", FontWeight.BOLD, 16));
        return l;
    }

    private Button primaryButton(String text) {
        Button b = new Button(text);
        b.setStyle(
                "-fx-background-color:#2F81F7;" +
                        "-fx-text-fill:white;" +
                        "-fx-background-radius:10;"
        );
        return b;
    }
}
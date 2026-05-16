package com.example.planova;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DashboardPage {

    public Scene createScene() {

        BorderPane root = new BorderPane();

        // =================================
        // LEFT SIDEBAR
        // =================================

        VBox sidebar = new VBox(20);

        sidebar.setPadding(new Insets(30));
        sidebar.setPrefWidth(220);

        sidebar.setStyle("""
                -fx-background-color: #111827;
                """);

        Label logo = new Label("PLANOVA");

        logo.setTextFill(Color.WHITE);

        logo.setFont(Font.font(26));

        Button homeBtn = createSidebarButton("🏠 Home");
        Button tasksBtn = createSidebarButton("📝 Tasks");
        Button aiBtn = createSidebarButton("🤖 AI Plans");
        Button analyticsBtn = createSidebarButton("📊 Analytics");
        Button settingsBtn = createSidebarButton("⚙ Settings");

        sidebar.getChildren().addAll(
                logo,
                homeBtn,
                tasksBtn,
                aiBtn,
                analyticsBtn,
                settingsBtn
        );

        // =================================
        // CENTER CONTENT
        // =================================

        VBox center = new VBox(25);

        center.setPadding(new Insets(30));

        center.setStyle("""
                -fx-background-color: #F3F4F6;
                """);

        Label welcome = new Label("Welcome Back 👋");

        welcome.setFont(Font.font(30));

        Label subtitle = new Label("Manage your smart plans easily");

        subtitle.setStyle("""
                -fx-text-fill: gray;
                -fx-font-size: 15;
                """);

        // =================================
        // CARDS
        // =================================

        HBox cards = new HBox(20);

        VBox tasksCard = createCard(
                "Today's Tasks",
                "8",
                "#2563EB"
        );

        VBox completedCard = createCard(
                "Completed",
                "5",
                "#10B981"
        );

        VBox productivityCard = createCard(
                "AI Productivity",
                "92%",
                "#F59E0B"
        );

        cards.getChildren().addAll(
                tasksCard,
                completedCard,
                productivityCard
        );

        // =================================
        // AI SECTION
        // =================================

        VBox aiSection = new VBox(15);

        aiSection.setPadding(new Insets(25));

        aiSection.setStyle("""
                -fx-background-color: white;
                -fx-background-radius: 20;
                """);

        Label aiTitle = new Label("Generate Smart AI Plan");

        aiTitle.setFont(Font.font(24));

        Label aiDesc = new Label(
                "Choose your planning strategy and generate your day automatically."
        );

        aiDesc.setStyle("""
                -fx-text-fill: gray;
                """);

        Button generateBtn = new Button("Generate Plan");

        generateBtn.setPrefWidth(220);
        generateBtn.setPrefHeight(45);

        generateBtn.setStyle("""
                -fx-background-color: #2563EB;
                -fx-text-fill: white;
                -fx-font-size: 16;
                -fx-background-radius: 10;
                """);

        aiSection.getChildren().addAll(
                aiTitle,
                aiDesc,
                generateBtn
        );

        center.getChildren().addAll(
                welcome,
                subtitle,
                cards,
                aiSection
        );

        // =================================
        // ADD TO ROOT
        // =================================

        root.setLeft(sidebar);

        root.setCenter(center);

        return new Scene(root, 1100, 700);
    }

    // =================================
    // SIDEBAR BUTTON
    // =================================

    private Button createSidebarButton(String text) {

        Button button = new Button(text);

        button.setPrefWidth(170);
        button.setPrefHeight(40);

        button.setAlignment(Pos.CENTER_LEFT);

        button.setStyle("""
                -fx-background-color: transparent;
                -fx-text-fill: white;
                -fx-font-size: 15;
                """);

        return button;
    }

    // =================================
    // CARD
    // =================================

    private VBox createCard(String title, String value, String color) {

        VBox card = new VBox(15);

        card.setPadding(new Insets(20));

        card.setPrefWidth(220);
        card.setPrefHeight(130);

        card.setStyle("""
                -fx-background-color: white;
                -fx-background-radius: 15;
                """);

        Label titleLabel = new Label(title);

        titleLabel.setStyle("""
                -fx-font-size: 18;
                -fx-font-weight: bold;
                """);

        Label valueLabel = new Label(value);

        valueLabel.setStyle("""
                -fx-font-size: 35;
                -fx-font-weight: bold;
                -fx-text-fill: %s;
                """.formatted(color));

        card.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        return card;
    }
}

package com.example.planova.views;

import com.example.planova.controllers.NavigationController;
import com.example.planova.controllers.PlansController;
import com.example.planova.styles.AppColors;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class DashboardView {

    private HBox root;
    private VBox sidebar;
    private VBox mainContent;
    private ScrollPane scrollPane;

    private NavigationController navigationController;

    public DashboardView(NavigationController nav) {
        this.navigationController = nav;
        createUI();
    }

    public Parent getView() {
        return root;
    }

    private void createUI() {

        root = new HBox();
        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        sidebar = createSidebar();

        mainContent = new VBox(22);
        mainContent.setPadding(new Insets(28, 38, 28, 38));
        HBox.setHgrow(mainContent, Priority.ALWAYS);

        VBox header = createHeader("Alex");

        HBox statsGrid = new HBox(18);
        statsGrid.getChildren().addAll(
                createStatCard("6.5h", "Deep Work Today", "+0.4h"),
                createStatCard("67%", "Task Completion", "Stable"),
                createStatCard("14", "Day Streak", "New High"),
                createStatCard("92", "Focus Score", "Top 5%")
        );

        HBox middleSection = new HBox(22);

        VBox focusCard = createFocusCard();
        VBox performanceCard = createPerformancePlaceholder();

        HBox.setHgrow(focusCard, Priority.ALWAYS);
        performanceCard.setMinWidth(340);

        middleSection.getChildren().addAll(focusCard, performanceCard);

        HBox bottomSection = new HBox(22);

        VBox sprintCard = createSprintCard();
        VBox assistantCard = createAssistantCard();

        HBox.setHgrow(sprintCard, Priority.ALWAYS);

        bottomSection.getChildren().addAll(sprintCard, assistantCard);

        mainContent.getChildren().addAll(
                header,
                statsGrid,
                middleSection,
                bottomSection
        );

        scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background: transparent;" +
                        "-fx-background-color: transparent;"
        );

        HBox.setHgrow(scrollPane, Priority.ALWAYS);

        root.getChildren().addAll(sidebar, scrollPane);

        playIntroAnimation();
    }

    //================================================
    // Animation
    //================================================
    private void playIntroAnimation() {

        mainContent.setTranslateY(-35);
        mainContent.setOpacity(0);

        TranslateTransition slide =
                new TranslateTransition(Duration.millis(650), mainContent);
        slide.setFromY(-35);
        slide.setToY(0);

        FadeTransition fade =
                new FadeTransition(Duration.millis(650), mainContent);
        fade.setFromValue(0);
        fade.setToValue(1);

        slide.play();
        fade.play();
    }

    //================================================
    // Sidebar Navigation (FIXED)
    //================================================
    private VBox createSidebar() {

        VBox box = new VBox(14);

        box.setPadding(new Insets(25));
        box.setPrefWidth(230);

        box.setStyle(
                "-fx-background-color: #151A21;" +
                        "-fx-border-color: #222831;" +
                        "-fx-border-width: 0 1 0 0;"
        );

        Label title = new Label("PLANOVA");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("System", FontWeight.BOLD, 22));

        Region space = new Region();
        space.setMinHeight(18);

        box.getChildren().addAll(
                title,
                space,
                navBtn("Home"),
                navBtn("Plans"),
                navBtn("Tasks"),
                navBtn("Analytics"),
                navBtn("Settings")
        );

        return box;
    }

    private Button navBtn(String name) {

        Button btn = new Button(name);

        btn.setPrefWidth(180);
        btn.setPrefHeight(44);
        btn.setAlignment(Pos.CENTER_LEFT);

        btn.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #D6D6D6;" +
                        "-fx-font-size: 13.5;" +
                        "-fx-background-radius: 10;"
        );

        btn.setOnMouseEntered(e ->
                btn.setStyle(
                        "-fx-background-color: #1F2630;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-size: 13.5;" +
                                "-fx-background-radius: 10;"
                )
        );

        btn.setOnMouseExited(e ->
                btn.setStyle(
                        "-fx-background-color: transparent;" +
                                "-fx-text-fill: #D6D6D6;" +
                                "-fx-font-size: 13.5;" +
                                "-fx-background-radius: 10;"
                )
        );

        btn.setOnAction(e -> {

            switch (name) {

                case "Home":
                    navigationController.goTo(
                            new DashboardView(navigationController).getView()
                    );
                    break;

                case "Plans":
                    navigationController.goTo(
                            new PlansController(navigationController).getView()
                    );
                    break;

                case "Tasks":
                    navigationController.goTo(
                            new TasksView(navigationController).getView()
                    );
                    break;

                case "Analytics":
                    navigationController.goTo(
                            new AnalyticsView(navigationController).getView()
                    );
                    break;

                case "Settings":
                    navigationController.goTo(
                            new SettingsView(navigationController).getView()
                    );
                    break;
            }
        });

        return btn;
    }

    //================================================
    // Header
    //================================================
    private VBox createHeader(String name) {

        VBox header = new VBox(6);

        Label welcome = new Label("Welcome back, " + name);
        welcome.setFont(Font.font("System", FontWeight.BOLD, 30));
        welcome.setTextFill(Color.WHITE);

        Label sub = new Label(
                "Your productivity is up 12% this week. Let's tackle your priorities."
        );

        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
        sub.setFont(Font.font(13));

        header.getChildren().addAll(welcome, sub);

        return header;
    }

    //================================================
    // Stat Card
    //================================================
    private VBox createStatCard(String value, String title, String trend) {

        VBox card = new VBox(8);

        card.setPadding(new Insets(18));
        card.setPrefWidth(220);

        card.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 14;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 14;"
        );

        Label val = new Label(value);
        val.setFont(Font.font("System", FontWeight.BOLD, 26));
        val.setTextFill(Color.WHITE);

        Label t = new Label(title);
        t.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Label tr = new Label(trend);
        tr.setTextFill(Color.web(AppColors.PRIMARY));

        card.getChildren().addAll(val, t, tr);

        return card;
    }

    //================================================
    // Focus Card
    //================================================
    private VBox createFocusCard() {

        VBox card = new VBox(14);
        card.setPadding(new Insets(18));

        card.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 18;"
        );

        Label title = new Label("Today's Focus");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font(17));

        card.getChildren().add(title);

        card.getChildren().add(createTaskItem("System Architecture Audit", "Engineering", "10:00 AM"));
        card.getChildren().add(createTaskItem("AI Fine-tuning", "Development", "01:30 PM"));
        card.getChildren().add(createTaskItem("Daily Standup", "Meetings", "04:00 PM"));

        return card;
    }

    private HBox createTaskItem(String name, String tag, String time) {

        HBox item = new HBox(12);
        item.setAlignment(Pos.CENTER_LEFT);
        item.setPadding(new Insets(10));

        item.setStyle(
                "-fx-background-color: #1F2630;" +
                        "-fx-background-radius: 10;"
        );

        CheckBox cb = new CheckBox();

        VBox info = new VBox(2);

        Label n = new Label(name);
        n.setTextFill(Color.WHITE);

        Label s = new Label(tag + " • " + time);
        s.setTextFill(Color.web("#A0A4AB"));

        info.getChildren().addAll(n, s);

        item.getChildren().addAll(cb, info);

        return item;
    }

    //================================================
    // Performance
    //================================================
    private VBox createPerformancePlaceholder() {

        VBox card = new VBox(14);

        card.setPadding(new Insets(18));

        card.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 18;"
        );

        Label title = new Label("Performance");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font(17));

        StackPane graph = new StackPane(new Label("Line Chart"));
        graph.setMinHeight(160);

        card.getChildren().addAll(title, graph);

        return card;
    }

    //================================================
    // Sprint
    //================================================
    private VBox createSprintCard() {

        VBox card = new VBox(12);
        card.setPadding(new Insets(18));

        card.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 18;"
        );

        Label title = new Label("Sprint Ready");
        title.setTextFill(Color.WHITE);

        Label desc = new Label("High productivity phase detected.");
        desc.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        card.getChildren().addAll(title, desc);

        return card;
    }

    //================================================
    // Assistant
    //================================================
    private VBox createAssistantCard() {

        VBox card = new VBox(10);
        card.setPadding(new Insets(18));

        card.setStyle(
                "-fx-background-color: #241B3A;" +
                        "-fx-background-radius: 18;"
        );

        Label title = new Label("Nova Assistant");
        title.setTextFill(Color.WHITE);

        Label msg = new Label("You're 75% closer to your goal.");
        msg.setTextFill(Color.web("#D0D0D0"));
        msg.setWrapText(true);

        card.getChildren().addAll(title, msg);

        return card;
    }
}
package com.example.planova.views;

import com.example.planova.controllers.*;
import com.example.planova.styles.AppColors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AnalyticsView {

    private BorderPane root;
    private VBox sidebar;
    private VBox mainContent;

    private NavigationController nav;

    public AnalyticsView(NavigationController nav) {
        this.nav = nav;
        createUI();
    }

    public Parent getView() {
        return root;
    }

    //================================================
    // UI
    //================================================

    private void createUI() {

        root = new BorderPane();

        root.setStyle(
                "-fx-background-color:" + AppColors.BACKGROUND + ";"
        );

        sidebar = createSidebar();

        mainContent = new VBox(22);
        mainContent.setPadding(new Insets(30));

        mainContent.setStyle(
                "-fx-background-color:" + AppColors.BACKGROUND + ";"
        );

        //------------------------------------------------
        // TOP BAR
        //------------------------------------------------

        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("Performance Insights");

        title.setFont(Font.font("System", FontWeight.BOLD, 30));
        title.setTextFill(Color.WHITE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        TextField search = new TextField();
        search.setPromptText("Search analytics...");
        search.setPrefWidth(260);

        search.setStyle(
                "-fx-background-color:#1F2630;" +
                        "-fx-text-fill:white;" +
                        "-fx-prompt-text-fill:#7D8590;" +
                        "-fx-background-radius:10;"
        );

        topBar.getChildren().addAll(title, spacer, search);

        Label sub = new Label(
                "Real-time productivity metrics powered by PlanNova AI."
        );

        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        //------------------------------------------------
        // BODY
        //------------------------------------------------

        VBox body = new VBox(20);

        HBox metricsRow = new HBox(20);

        metricsRow.getChildren().addAll(
                createProductivityCard(),
                createHeatmapCard(),
                createStreakCard()
        );

        HBox insightsRow = new HBox(20);

        VBox leftSide = new VBox(20);

        leftSide.getChildren().addAll(
                createEfficiencyAlert(),
                createTaskDistribution()
        );

        VBox rightSide = new VBox(20);

        rightSide.setPrefWidth(340);

        rightSide.getChildren().addAll(
                createAIInsightsCard(),
                createBurnoutCard(),
                createActivityCard()
        );

        insightsRow.getChildren().addAll(leftSide, rightSide);

        Button export = new Button("Export Report");

        export.setPrefWidth(180);
        export.setPrefHeight(44);

        export.setStyle(
                "-fx-background-color:#2F81F7;" +
                        "-fx-text-fill:white;" +
                        "-fx-font-size:14;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:12;"
        );

        body.getChildren().addAll(
                metricsRow,
                insightsRow,
                export
        );

        mainContent.getChildren().addAll(
                topBar,
                sub,
                body
        );

        root.setLeft(sidebar);

        ScrollPane scroll = new ScrollPane(mainContent);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background:" + AppColors.BACKGROUND + ";" +
                        "-fx-background-color:" + AppColors.BACKGROUND + ";"
        );

        root.setCenter(scroll);
    }

    //================================================
    // SIDEBAR
    //================================================

    private VBox createSidebar() {

        VBox box = new VBox(14);

        box.setPadding(new Insets(25));
        box.setPrefWidth(220);

        box.setStyle(
                "-fx-background-color:#151A21;" +
                        "-fx-border-color:#222831;" +
                        "-fx-border-width:0 1 0 0;"
        );

        Label logo = new Label("PLANOVA");

        logo.setTextFill(Color.WHITE);

        logo.setFont(
                Font.font("System", FontWeight.BOLD, 22)
        );

        Region space = new Region();
        space.setMinHeight(18);

        box.getChildren().addAll(
                logo,
                space,
                navButton("Home"),
                navButton("Plans"),
                navButton("Tasks"),
                navButton("Analytics"),
                navButton("Settings")
        );

        return box;
    }

    //================================================
    // NAV BUTTON
    //================================================

    private Button navButton(String text) {

        Button btn = new Button(text);

        btn.setPrefWidth(180);
        btn.setPrefHeight(42);

        btn.setAlignment(Pos.CENTER_LEFT);

        btn.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill:#D6D6D6;" +
                        "-fx-font-size:13;" +
                        "-fx-background-radius:10;"
        );

        btn.setOnMouseEntered(e ->
                btn.setStyle(
                        "-fx-background-color:#1F2630;" +
                                "-fx-text-fill:white;" +
                                "-fx-font-size:13;" +
                                "-fx-background-radius:10;"
                )
        );

        btn.setOnMouseExited(e ->
                btn.setStyle(
                        "-fx-background-color: transparent;" +
                                "-fx-text-fill:#D6D6D6;" +
                                "-fx-font-size:13;" +
                                "-fx-background-radius:10;"
                )
        );

        btn.setOnAction(e -> {

            switch (text) {

                case "Home":
                    nav.goTo(new DashboardController(nav).getView());
                    break;

                case "Plans":
                    nav.goTo(new PlansController(nav).getView());
                    break;

                case "Tasks":
                    nav.goTo(new TasksController(nav).getView());
                    break;

                case "Analytics":
                    nav.goTo(new AnalyticsController(nav).getView());
                    break;

                case "Settings":
                    nav.goTo(new SettingsController(nav).getView());
                    break;
            }
        });

        return btn;
    }

    //================================================
    // CARDS
    //================================================

    private VBox createProductivityCard() {

        VBox card = createCard();

        Label title = cardTitle("Productivity Score");

        Label score = new Label("42.5h");

        score.setFont(Font.font("System", FontWeight.BOLD, 34));
        score.setTextFill(Color.WHITE);

        Label sub = new Label(
                "Your efficiency is 12% higher than last week."
        );

        sub.setWrapText(true);
        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        card.getChildren().addAll(title, score, sub);

        return card;
    }

    private VBox createHeatmapCard() {

        VBox card = createCard();

        Label title = cardTitle("Productivity Heatmap");

        Label optimal = new Label("OPTIMAL");

        optimal.setTextFill(Color.web(AppColors.PRIMARY));

        optimal.setFont(
                Font.font("System", FontWeight.BOLD, 28)
        );

        Label value = new Label("85");

        value.setTextFill(Color.WHITE);

        ProgressBar bar = new ProgressBar(0.85);
        bar.setPrefWidth(220);

        card.getChildren().addAll(
                title,
                optimal,
                value,
                bar
        );

        return card;
    }

    private VBox createStreakCard() {

        VBox card = createCard();

        Label title = cardTitle("Daily Streak");

        Label days = new Label("14 DAYS");

        days.setTextFill(Color.WHITE);

        days.setFont(
                Font.font("System", FontWeight.BOLD, 30)
        );

        Label txt = new Label(
                "Consistency unlocks high performance."
        );

        txt.setWrapText(true);

        txt.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        card.getChildren().addAll(title, days, txt);

        return card;
    }

    private VBox createEfficiencyAlert() {

        VBox card = createCard();

        Label title = cardTitle("Efficiency Alert");

        Label text = new Label(
                "Your most productive window is between 9:00 AM and 11:30 AM.\n\n" +
                        "Consider scheduling strategy planning tasks then."
        );

        text.setWrapText(true);

        text.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Button apply = new Button("Apply To Schedule");

        apply.setStyle(
                "-fx-background-color:" + AppColors.PRIMARY + ";" +
                        "-fx-text-fill:white;" +
                        "-fx-background-radius:10;"
        );

        card.getChildren().addAll(
                title,
                text,
                apply
        );

        return card;
    }

    private VBox createTaskDistribution() {

        VBox card = createCard();

        Label title = cardTitle("Weekly Task Distribution");

        card.getChildren().addAll(
                title,
                distributionRow("Deep Work", "70%"),
                distributionRow("Admin", "20%"),
                distributionRow("Meetings", "10%")
        );

        return card;
    }

    private VBox createAIInsightsCard() {

        VBox card = createCard();

        Label title = cardTitle("AI Insights");

        Label txt = new Label(
                "Project Alpha velocity is currently 3.2 days ahead of schedule."
        );

        txt.setWrapText(true);

        txt.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        card.getChildren().addAll(title, txt);

        return card;
    }

    private VBox createBurnoutCard() {

        VBox card = createCard();

        Label title = cardTitle("Burnout Risk");

        Label txt = new Label(
                "Your screen time increased by 24% this week.\n\n" +
                        "Recommendation: Analog Afternoon this Saturday."
        );

        txt.setWrapText(true);

        txt.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Button reminder = new Button("Set Reminder");

        reminder.setStyle(
                "-fx-background-color:#FF6B6B;" +
                        "-fx-text-fill:white;" +
                        "-fx-background-radius:10;"
        );

        card.getChildren().addAll(
                title,
                txt,
                reminder
        );

        return card;
    }

    private VBox createActivityCard() {

        VBox card = createCard();

        Label title = cardTitle("Recent Activity");

        card.getChildren().addAll(
                title,
                activityItem(
                        "Finished: Q4 Roadmaps",
                        "2 hours ago"
                ),
                activityItem(
                        "Streak Extended: 14 Days",
                        "9 hours ago"
                )
        );

        return card;
    }

    //================================================
    // HELPERS
    //================================================

    private VBox createCard() {

        VBox card = new VBox(14);

        card.setPadding(new Insets(18));

        card.setStyle(
                "-fx-background-color:" + AppColors.CARD + ";" +
                        "-fx-background-radius:18;" +
                        "-fx-border-color:#2A2F3A;" +
                        "-fx-border-radius:18;"
        );

        VBox.setVgrow(card, Priority.ALWAYS);

        return card;
    }

    private Label cardTitle(String text) {

        Label l = new Label(text);

        l.setTextFill(Color.WHITE);

        l.setFont(
                Font.font("System", FontWeight.BOLD, 18)
        );

        return l;
    }

    private HBox distributionRow(String name, String percent) {

        HBox row = new HBox();

        row.setAlignment(Pos.CENTER_LEFT);

        Label left = new Label(name);
        left.setTextFill(Color.WHITE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label right = new Label(percent);

        right.setTextFill(
                Color.web(AppColors.PRIMARY)
        );

        row.getChildren().addAll(
                left,
                spacer,
                right
        );

        return row;
    }

    private VBox activityItem(String title, String time) {

        VBox box = new VBox(4);

        box.setPadding(new Insets(12));

        box.setStyle(
                "-fx-background-color:#1F2630;" +
                        "-fx-background-radius:12;"
        );

        Label t1 = new Label(title);

        t1.setTextFill(Color.WHITE);

        Label t2 = new Label(time);

        t2.setTextFill(
                Color.web(AppColors.SECONDARY_TEXT)
        );

        box.getChildren().addAll(t1, t2);

        return box;
    }
}
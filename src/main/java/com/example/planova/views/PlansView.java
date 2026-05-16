
//package com.example.planova.views;
//
//import com.example.planova.controllers.*;
//import com.example.planova.styles.AppColors;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//
//public class PlansView {
//
//    private BorderPane root;
//    private VBox sidebar;
//    private VBox mainContent;
//
//    private NavigationController nav;
//
//    public PlansView(NavigationController nav) {
//        this.nav = nav;
//        createUI();
//    }
//
//    public Parent getView() {
//        return root;
//    }
//
//    private void createUI() {
//
//        root = new BorderPane();
//        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        sidebar = createSidebar();
//
//        mainContent = new VBox(22);
//        mainContent.setPadding(new Insets(30));
//        mainContent.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        // ==================== TOP BAR ====================
//        HBox topBar = createTopBar();
//
//        Label sub = new Label("Visualizing your high-performance trajectory for the week.");
//        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        // ==================== BODY ====================
//        HBox body = new HBox(22);
//
//        VBox leftSide = new VBox(20);
//        leftSide.getChildren().addAll(
//                createTimelineCard(),
//                createAICard()
//        );
//        HBox.setHgrow(leftSide, Priority.ALWAYS);
//
//        VBox rightSide = new VBox(20);
//        rightSide.getChildren().addAll(
//                createWorkloadCard(),
//                createEnergyCard(),
//                createDomainsCard()
//        );
//        rightSide.setPrefWidth(320);
//
//        body.getChildren().addAll(leftSide, rightSide);
//
//        // ==================== QUICK TASK ====================
//        HBox quickTask = createQuickTaskSection();
//
//        // ==================== NEW PLAN BUTTON ====================
//        Button newPlan = new Button("New Plan");
//        newPlan.setPrefWidth(180);
//        newPlan.setPrefHeight(44);
//        newPlan.setStyle(
//                "-fx-background-color:" + AppColors.PRIMARY + ";" +
//                        "-fx-text-fill:white;" +
//                        "-fx-font-size:14;" +
//                        "-fx-font-weight:bold;" +
//                        "-fx-background-radius:12;"
//        );
//
//        // Open New Plan Screen
//        newPlan.setOnAction(e -> nav.goTo(new NewPlanView(nav).getView()));
//
//        mainContent.getChildren().addAll(
//                topBar,
//                sub,
//                body,
//                quickTask,
//                newPlan
//        );
//
//        root.setLeft(sidebar);
//
//        ScrollPane scroll = new ScrollPane(mainContent);
//        scroll.setFitToWidth(true);
//        scroll.setStyle(
//                "-fx-background:" + AppColors.BACKGROUND + ";" +
//                        "-fx-background-color:" + AppColors.BACKGROUND + ";"
//        );
//
//        root.setCenter(scroll);
//    }
//
//    //================================================
//    // TOP BAR
//    //================================================
//    private HBox createTopBar() {
//        HBox topBar = new HBox();
//        topBar.setAlignment(Pos.CENTER_LEFT);
//
//        Label title = new Label("Weekly Architecture");
//        title.setFont(Font.font("System", FontWeight.BOLD, 28));
//        title.setTextFill(Color.WHITE);
//
//        Region spacer = new Region();
//        HBox.setHgrow(spacer, Priority.ALWAYS);
//
//        TextField search = new TextField();
//        search.setPromptText("Search tasks or insights...");
//        search.setPrefWidth(260);
//        search.setStyle(
//                "-fx-background-color: #1F2630;" +
//                        "-fx-text-fill: white;" +
//                        "-fx-prompt-text-fill: #7D8590;" +
//                        "-fx-background-radius: 10;" +
//                        "-fx-border-radius: 10;"
//        );
//
//        topBar.getChildren().addAll(title, spacer, search);
//        return topBar;
//    }
//
//    //================================================
//    // QUICK TASK SECTION
//    //================================================
//    private HBox createQuickTaskSection() {
//        HBox quickTask = new HBox(12);
//        quickTask.setAlignment(Pos.CENTER_LEFT);
//        quickTask.setPadding(new Insets(18));
//        quickTask.setStyle(
//                "-fx-background-color: " + AppColors.CARD + ";" +
//                        "-fx-background-radius: 16;" +
//                        "-fx-border-color:#2A2F3A;" +
//                        "-fx-border-radius:16;"
//        );
//
//        TextField taskField = new TextField();
//        taskField.setPromptText("Add a quick task for today...");
//        taskField.setPrefHeight(40);
//        taskField.setStyle(
//                "-fx-background-color:#1F2630;" +
//                        "-fx-text-fill:white;" +
//                        "-fx-prompt-text-fill:#7D8590;" +
//                        "-fx-background-radius:10;"
//        );
//
//        HBox.setHgrow(taskField, Priority.ALWAYS);
//
//        Button addTask = new Button("Add Task");
//        addTask.setStyle(
//                "-fx-background-color:" + AppColors.PRIMARY + ";" +
//                        "-fx-text-fill:white;" +
//                        "-fx-background-radius:10;"
//        );
//        addTask.setPrefHeight(40);
//
//        quickTask.getChildren().addAll(taskField, addTask);
//        return quickTask;
//    }
//
//    //================================================
//    // SIDEBAR
//    //================================================
//
//    private VBox createSidebar() {
//        VBox box = new VBox(14);
//        box.setPadding(new Insets(25));
//        box.setPrefWidth(220);
//
//        box.setStyle(
//                "-fx-background-color:#151A21;" +
//                        "-fx-border-color:#222831;" +
//                        "-fx-border-width:0 1 0 0;"
//        );
//
//        Label logo = new Label("PLANOVA");
//        logo.setTextFill(Color.WHITE);
//        logo.setFont(Font.font("System", FontWeight.BOLD, 22));
//
//        Region space = new Region();
//        space.setMinHeight(18);
//
//        box.getChildren().addAll(
//                logo,
//                space,
//                navButton("Home"),
//                navButton("Plans"),
//                navButton("Tasks"),
//                navButton("Analytics"),
//                navButton("Settings")
//        );
//
//        return box;
//    }
//
//    //================================================
//    // NAV BUTTON
//    //================================================
//
//    private Button navButton(String text) {
//        Button btn = new Button(text);
//        btn.setPrefWidth(180);
//        btn.setPrefHeight(42);
//        btn.setAlignment(Pos.CENTER_LEFT);
//
//        btn.setStyle(
//                "-fx-background-color: transparent;" +
//                        "-fx-text-fill:#D6D6D6;" +
//                        "-fx-font-size:13;" +
//                        "-fx-background-radius:10;"
//        );
//
//        btn.setOnMouseEntered(e ->
//                btn.setStyle(
//                        "-fx-background-color:#1F2630;" +
//                                "-fx-text-fill:white;" +
//                                "-fx-font-size:13;" +
//                                "-fx-background-radius:10;"
//                )
//        );
//
//        btn.setOnMouseExited(e ->
//                btn.setStyle(
//                        "-fx-background-color: transparent;" +
//                                "-fx-text-fill:#D6D6D6;" +
//                                "-fx-font-size:13;" +
//                                "-fx-background-radius:10;"
//                )
//        );
//
//        btn.setOnAction(e -> {
//            switch (text) {
//                case "Home" -> nav.goTo(new DashboardController(nav).getView());
//                case "Plans" -> nav.goTo(new PlansController(nav).getView());
//                case "Tasks" -> nav.goTo(new TasksController(nav).getView());
//                case "Analytics" -> nav.goTo(new AnalyticsController(nav).getView());
//                case "Settings" -> nav.goTo(new SettingsController(nav).getView());
//            }
//        });
//
//        return btn;
//    }
//
//    //================================================
//    // CARDS
//    //================================================
//
//    private VBox createTimelineCard() {
//        VBox card = createCard();
//        Label title = cardTitle("Tuesday Timeline");
//
//        VBox task1 = taskBlock("09:00 — 10:30 AM", "Enterprise API Refactoring",
//                "Optimize the legacy endpoints for the Q4 rollout.", "65% Done");
//
//        VBox task2 = taskBlock("11:00 — 12:00 PM", "Global Design Sync",
//                "Weekly touchpoint with the London and Tokyo teams.", "Collaboration");
//
//        card.getChildren().addAll(title, task1, task2);
//        return card;
//    }
//
//    private VBox createAICard() {
//        VBox card = createCard();
//        Label title = cardTitle("PlanNova AI");
//
//        Label msg = new Label("\"You have a high concentration of meetings on Wednesday afternoon. "
//                + "I recommend moving the Product Specs task to Thursday morning.\"");
//        msg.setWrapText(true);
//        msg.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        Button optimize = new Button("View Smart Reschedule");
//        optimize.setStyle("-fx-background-color:" + AppColors.PRIMARY + ";"
//                + "-fx-text-fill:white;-fx-background-radius:10;");
//
//        card.getChildren().addAll(title, msg, optimize);
//        return card;
//    }
//
//    private VBox createWorkloadCard() {
//        VBox card = createCard();
//        Label title = cardTitle("Workload Balance");
//
//        Label optimal = new Label("OPTIMAL");
//        optimal.setTextFill(Color.web(AppColors.PRIMARY));
//        optimal.setFont(Font.font("System", FontWeight.BOLD, 26));
//
//        Label hours = new Label("12 / 16h Capacity");
//        hours.setTextFill(Color.WHITE);
//
//        ProgressBar bar = new ProgressBar(0.75);
//        bar.setPrefWidth(240);
//
//        card.getChildren().addAll(title, optimal, hours, bar);
//        return card;
//    }
//
//    private VBox createEnergyCard() {
//        VBox card = createCard();
//        Label title = cardTitle("Energy Peak Analysis");
//
//        Label txt = new Label("AI Suggested: Lunch Recovery\n\n"
//                + "Your focus patterns suggest a 20-minute cognitive break.");
//        txt.setWrapText(true);
//        txt.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        card.getChildren().addAll(title, txt);
//        return card;
//    }
//
//    private VBox createDomainsCard() {
//        VBox card = createCard();
//        Label title = cardTitle("Domains");
//
//        card.getChildren().addAll(
//                title,
//                domainBar("ENGINEERING", "45%"),
//                domainBar("LEADERSHIP", "30%"),
//                domainBar("STRATEGY", "25%")
//        );
//        return card;
//    }
//
//    //================================================
//    // HELPERS
//    //================================================
//
//    private VBox createCard() {
//        VBox card = new VBox(14);
//        card.setPadding(new Insets(18));
//        card.setStyle(
//                "-fx-background-color:" + AppColors.CARD + ";" +
//                        "-fx-background-radius:18;" +
//                        "-fx-border-color:#2A2F3A;" +
//                        "-fx-border-radius:18;"
//        );
//        return card;
//    }
//
//    private Label cardTitle(String text) {
//        Label l = new Label(text);
//        l.setTextFill(Color.WHITE);
//        l.setFont(Font.font("System", FontWeight.BOLD, 18));
//        return l;
//    }
//
//    private VBox taskBlock(String time, String title, String desc, String badge) {
//        VBox box = new VBox(8);
//        box.setPadding(new Insets(16));
//        box.setStyle("-fx-background-color:#1F2630; -fx-background-radius:14;");
//
//        Label t1 = new Label(time);
//        t1.setTextFill(Color.web(AppColors.PRIMARY));
//        t1.setFont(Font.font("System", FontWeight.BOLD, 13));
//
//        Label t2 = new Label(title);
//        t2.setTextFill(Color.WHITE);
//        t2.setFont(Font.font("System", FontWeight.BOLD, 16));
//
//        Label t3 = new Label(desc);
//        t3.setWrapText(true);
//        t3.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        Label status = new Label(badge);
//        status.setTextFill(Color.WHITE);
//        status.setStyle("-fx-background-color:#2F81F7; -fx-padding:6 12 6 12; -fx-background-radius:20;");
//
//        box.getChildren().addAll(t1, t2, t3, status);
//        return box;
//    }
//
//    private HBox domainBar(String name, String percent) {
//        HBox row = new HBox();
//        row.setAlignment(Pos.CENTER_LEFT);
//
//        Label left = new Label(name);
//        left.setTextFill(Color.WHITE);
//
//        Region spacer = new Region();
//        HBox.setHgrow(spacer, Priority.ALWAYS);
//
//        Label right = new Label(percent);
//        right.setTextFill(Color.web(AppColors.PRIMARY));
//
//        row.getChildren().addAll(left, spacer, right);
//        return row;
//    }
//}

package com.example.planova.views;

import com.example.planova.controllers.*;
import com.example.planova.data.AppData;
import com.example.planova.models.Task;
import com.example.planova.models.WeeklyPlan;
import com.example.planova.styles.AppColors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlansView {

    private BorderPane root;
    private VBox sidebar;
    private VBox mainContent;
    private VBox quickTasksList;   // لعرض المهام المضافة سريعاً

    private NavigationController nav;

    public PlansView(NavigationController nav) {
        this.nav = nav;
        createUI();
    }

    public Parent getView() {
        return root;
    }

    private void createUI() {

        root = new BorderPane();
        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        sidebar = createSidebar();

        mainContent = new VBox(22);
        mainContent.setPadding(new Insets(30));
        mainContent.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        // ==================== TOP BAR ====================
        HBox topBar = createTopBar();

        Label sub = new Label("Visualizing your high-performance trajectory for the week.");
        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        // ==================== BODY ====================
        HBox body = new HBox(22);

        VBox leftSide = new VBox(20);
        leftSide.getChildren().addAll(
                createTimelineCard(),
                createAICard()
        );
        HBox.setHgrow(leftSide, Priority.ALWAYS);

        VBox rightSide = new VBox(20);
        rightSide.getChildren().addAll(
                createWorkloadCard(),
                createEnergyCard(),
                createDomainsCard()
        );
        rightSide.setPrefWidth(320);

        body.getChildren().addAll(leftSide, rightSide);

        // ==================== QUICK TASK SECTION ====================
        VBox quickTaskSection = createQuickTaskSection();

        // ==================== NEW PLAN BUTTON ====================
        Button newPlan = new Button("New Plan");
        newPlan.setPrefWidth(180);
        newPlan.setPrefHeight(44);
        newPlan.setStyle(
                "-fx-background-color:" + AppColors.PRIMARY + ";" +
                        "-fx-text-fill:white;" +
                        "-fx-font-size:14;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:12;"
        );
        newPlan.setOnAction(e -> nav.goTo(new NewPlanView(nav).getView()));

        mainContent.getChildren().addAll(
                topBar,
                sub,
                body,
                quickTaskSection,
                newPlan
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
    // TOP BAR
    //================================================
    private HBox createTopBar() {
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("Weekly Architecture");
        title.setFont(Font.font("System", FontWeight.BOLD, 28));
        title.setTextFill(Color.WHITE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        TextField search = new TextField();
        search.setPromptText("Search tasks or insights...");
        search.setPrefWidth(260);
        search.setStyle(
                "-fx-background-color: #1F2630;" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: #7D8590;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 10;"
        );

        topBar.getChildren().addAll(title, spacer, search);
        return topBar;
    }

    //================================================
    // QUICK TASK SECTION (مع حفظ المهام)
    //================================================
    private VBox createQuickTaskSection() {
        VBox section = new VBox(12);

        HBox inputBox = new HBox(12);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setPadding(new Insets(18));
        inputBox.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 16;" +
                        "-fx-border-color:#2A2F3A;" +
                        "-fx-border-radius:16;"
        );

        TextField taskField = new TextField();
        taskField.setPromptText("Add a quick task for today...");
        taskField.setPrefHeight(40);
        taskField.setStyle(
                "-fx-background-color:#1F2630;" +
                        "-fx-text-fill:white;" +
                        "-fx-prompt-text-fill:#7D8590;" +
                        "-fx-background-radius:10;"
        );
        HBox.setHgrow(taskField, Priority.ALWAYS);

        Button addTaskBtn = new Button("Add Task");
        addTaskBtn.setStyle(
                "-fx-background-color:" + AppColors.PRIMARY + ";" +
                        "-fx-text-fill:white;" +
                        "-fx-background-radius:10;"
        );
        addTaskBtn.setPrefHeight(40);

        addTaskBtn.setOnAction(e -> {
            String title = taskField.getText().trim();
            if (!title.isEmpty()) {
                addQuickTask(title);
                taskField.clear();
            }
        });

        inputBox.getChildren().addAll(taskField, addTaskBtn);

        quickTasksList = new VBox(8);
        quickTasksList.setPadding(new Insets(5, 0, 0, 0));

        section.getChildren().addAll(inputBox, quickTasksList);
        return section;
    }

    private void addQuickTask(String title) {
        // إنشاء مهمة جديدة
        Task task = new Task(title, 60, "Quick Task", "Today");

        // حفظ في AppData
        if (AppData.currentPlan == null) {
            AppData.currentPlan = new WeeklyPlan("Quick Plan");
        }
        AppData.currentPlan.addTask(task);

        // عرض في الواجهة
        HBox taskRow = new HBox(12);
        taskRow.setPadding(new Insets(12));
        taskRow.setAlignment(Pos.CENTER_LEFT);
        taskRow.setStyle(
                "-fx-background-color: #1F2630;" +
                        "-fx-background-radius: 12;"
        );

        Label taskLabel = new Label("✓ " + title);
        taskLabel.setTextFill(Color.WHITE);
        HBox.setHgrow(taskLabel, Priority.ALWAYS);

        Label durationLabel = new Label("60 min");
        durationLabel.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Button deleteBtn = new Button("×");
        deleteBtn.setStyle("-fx-text-fill: #FF6B6B; -fx-background-color: transparent; -fx-font-size: 18;");

        deleteBtn.setOnAction(e -> quickTasksList.getChildren().remove(taskRow));

        taskRow.getChildren().addAll(taskLabel, durationLabel, deleteBtn);
        quickTasksList.getChildren().add(taskRow);
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
        logo.setFont(Font.font("System", FontWeight.BOLD, 22));

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
                btn.setStyle("-fx-background-color:#1F2630; -fx-text-fill:white; -fx-font-size:13; -fx-background-radius:10;")
        );

        btn.setOnMouseExited(e ->
                btn.setStyle("-fx-background-color: transparent; -fx-text-fill:#D6D6D6; -fx-font-size:13; -fx-background-radius:10;")
        );

        btn.setOnAction(e -> {
            switch (text) {
                case "Home" -> nav.goTo(new DashboardController(nav).getView());
                case "Plans" -> nav.goTo(new PlansController(nav).getView());
                case "Tasks" -> nav.goTo(new TasksController(nav).getView());
                case "Analytics" -> nav.goTo(new AnalyticsController(nav).getView());
                case "Settings" -> nav.goTo(new SettingsController(nav).getView());
            }
        });

        return btn;
    }

    //================================================
    // CARDS
    //================================================
    private VBox createTimelineCard() {
        VBox card = createCard();
        Label title = cardTitle("Tuesday Timeline");

        VBox task1 = taskBlock("09:00 — 10:30 AM", "Enterprise API Refactoring",
                "Optimize the legacy endpoints for the Q4 rollout.", "65% Done");

        VBox task2 = taskBlock("11:00 — 12:00 PM", "Global Design Sync",
                "Weekly touchpoint with the London and Tokyo teams.", "Collaboration");

        card.getChildren().addAll(title, task1, task2);
        return card;
    }

    private VBox createAICard() {
        VBox card = createCard();
        Label title = cardTitle("PlanNova AI");

        Label msg = new Label("\"You have a high concentration of meetings on Wednesday afternoon. "
                + "I recommend moving the Product Specs task to Thursday morning.\"");
        msg.setWrapText(true);
        msg.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Button optimize = new Button("View Smart Reschedule");
        optimize.setStyle("-fx-background-color:" + AppColors.PRIMARY + "; -fx-text-fill:white; -fx-background-radius:10;");

        card.getChildren().addAll(title, msg, optimize);
        return card;
    }

    private VBox createWorkloadCard() {
        VBox card = createCard();
        Label title = cardTitle("Workload Balance");

        Label optimal = new Label("OPTIMAL");
        optimal.setTextFill(Color.web(AppColors.PRIMARY));
        optimal.setFont(Font.font("System", FontWeight.BOLD, 26));

        Label hours = new Label("12 / 16h Capacity");
        hours.setTextFill(Color.WHITE);

        ProgressBar bar = new ProgressBar(0.75);
        bar.setPrefWidth(240);

        card.getChildren().addAll(title, optimal, hours, bar);
        return card;
    }

    private VBox createEnergyCard() {
        VBox card = createCard();
        Label title = cardTitle("Energy Peak Analysis");

        Label txt = new Label("AI Suggested: Lunch Recovery\n\nYour focus patterns suggest a 20-minute cognitive break.");
        txt.setWrapText(true);
        txt.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        card.getChildren().addAll(title, txt);
        return card;
    }

    private VBox createDomainsCard() {
        VBox card = createCard();
        Label title = cardTitle("Domains");

        card.getChildren().addAll(
                title,
                domainBar("ENGINEERING", "45%"),
                domainBar("LEADERSHIP", "30%"),
                domainBar("STRATEGY", "25%")
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
        return card;
    }

    private Label cardTitle(String text) {
        Label l = new Label(text);
        l.setTextFill(Color.WHITE);
        l.setFont(Font.font("System", FontWeight.BOLD, 18));
        return l;
    }

    private VBox taskBlock(String time, String title, String desc, String badge) {
        VBox box = new VBox(8);
        box.setPadding(new Insets(16));
        box.setStyle("-fx-background-color:#1F2630; -fx-background-radius:14;");

        Label t1 = new Label(time);
        t1.setTextFill(Color.web(AppColors.PRIMARY));
        t1.setFont(Font.font("System", FontWeight.BOLD, 13));

        Label t2 = new Label(title);
        t2.setTextFill(Color.WHITE);
        t2.setFont(Font.font("System", FontWeight.BOLD, 16));

        Label t3 = new Label(desc);
        t3.setWrapText(true);
        t3.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Label status = new Label(badge);
        status.setTextFill(Color.WHITE);
        status.setStyle("-fx-background-color:#2F81F7; -fx-padding:6 12 6 12; -fx-background-radius:20;");

        box.getChildren().addAll(t1, t2, t3, status);
        return box;
    }

    private HBox domainBar(String name, String percent) {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);

        Label left = new Label(name);
        left.setTextFill(Color.WHITE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label right = new Label(percent);
        right.setTextFill(Color.web(AppColors.PRIMARY));

        row.getChildren().addAll(left, spacer, right);
        return row;
    }
}
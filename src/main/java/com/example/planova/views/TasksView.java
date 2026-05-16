////package com.example.planova.views;
////
////import com.example.planova.controllers.*;
////import com.example.planova.controllers.NavigationController;
////import com.example.planova.styles.AppColors;
////import javafx.geometry.Insets;
////import javafx.geometry.Pos;
////import javafx.scene.Parent;
////import javafx.scene.control.*;
////import javafx.scene.layout.*;
////import javafx.scene.paint.Color;
////import javafx.scene.text.Font;
////import javafx.scene.text.FontWeight;
////
////public class TasksView {
////
////    private BorderPane root;
////    private VBox sidebar;
////    private VBox mainContent;
////    private NavigationController nav;
////
////    public TasksView(NavigationController nav) {
////        this.nav = nav;
////        createUI();
////    }
////
////    public Parent getView() {
////        return root;
////    }
////
////    private void createUI() {
////        root = new BorderPane();
////        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
////
////        sidebar = createSidebar();
////
////        mainContent = new VBox(20);
////        mainContent.setPadding(new Insets(25));
////        mainContent.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
////
////        // ==================== TOP BAR ====================
////        HBox topBar = createTopBar();
////
////        // ==================== HEADER ====================
////        HBox header = new HBox(15);
////        header.setAlignment(Pos.CENTER_LEFT);
////
////        Label title = new Label("Tasks");
////        title.setFont(Font.font("System", FontWeight.BOLD, 28));
////        title.setTextFill(Color.WHITE);
////
////        Label aiStatus = new Label("AI ANALYZING PRIORITY");
////        aiStatus.setStyle("-fx-background-color: #2A2F3A; -fx-padding: 6 14; -fx-background-radius: 20;");
////        aiStatus.setTextFill(Color.web("#A0B4FF"));
////
////        Region spacer = new Region();
////        HBox.setHgrow(spacer, Priority.ALWAYS);
////
////        Label stats = new Label("24 Tasks Total • 8 Completed Today");
////        stats.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
////
////        header.getChildren().addAll(title, aiStatus, spacer, stats);
////
////        // ==================== FILTERS ====================
////        HBox filters = createFilters();
////
////        // ==================== TASKS LIST ====================
////        VBox tasksList = new VBox(16);
////        tasksList.getChildren().addAll(
////                createTaskCard("Design System Architecture Refresh", "URGENT",
////                        "Consolidate the token system and update the layout components for the Q3 release cycle. Ensure high-performance glassmorphism renders correctly.",
////                        "Today, 5:00 PM", "Engineering", true),
////
////                createTaskCard("Update API Documentation", "MEDIUM",
////                        "Refactor the endpoint descriptions for the new productivity suite integration modules.",
////                        "Jun 12", "Documentation", false),
////
////                createTaskCard("Prepare Investor Q3 Deck", "HIGH",
////                        "Compile the analytics growth charts and upcoming feature roadmap for the quarterly board meeting.",
////                        "Jun 15", "Strategy", false)
////        );
////
////        mainContent.getChildren().addAll(topBar, header, filters, tasksList);
////
////        ScrollPane scrollPane = new ScrollPane(mainContent);
////        scrollPane.setFitToWidth(true);
////        scrollPane.setStyle("-fx-background: " + AppColors.BACKGROUND + "; -fx-background-color: " + AppColors.BACKGROUND + ";");
////
////        root.setLeft(sidebar);
////        root.setCenter(scrollPane);
////    }
////
////    private HBox createTopBar() {
////        HBox top = new HBox(20);
////        top.setAlignment(Pos.CENTER_LEFT);
////
////        TextField search = new TextField();
////        search.setPromptText("Search tasks, plans, or insights...");
////        search.setPrefWidth(380);
////        search.setStyle(
////                "-fx-background-color: #1F2630;" +
////                        "-fx-text-fill: white;" +
////                        "-fx-prompt-text-fill: #7D8590;" +
////                        "-fx-background-radius: 12;" +
////                        "-fx-border-radius: 12;" +
////                        "-fx-padding: 10;"
////        );
////
////        Region spacer = new Region();
////        HBox.setHgrow(spacer, Priority.ALWAYS);
////
////        Button listView = new Button("List View");
////        Button boardView = new Button("Board View");
////
////        listView.setStyle("-fx-background-color: #2F81F7; -fx-text-fill: white; -fx-background-radius: 8;");
////        boardView.setStyle("-fx-background-color: transparent; -fx-text-fill: #A0A8B8; -fx-background-radius: 8;");
////
////        top.getChildren().addAll(search, spacer, listView, boardView);
////        return top;
////    }
////
////    private HBox createFilters() {
////        HBox box = new HBox(12);
////        box.setAlignment(Pos.CENTER_LEFT);
////
////        Label sortLabel = new Label("SORT BY:");
////        sortLabel.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
////
////        ComboBox<String> sortCombo = new ComboBox<>();
////        sortCombo.getItems().addAll("Due Date", "Priority", "Title");
////        sortCombo.setValue("Due Date");
////
////        ToggleGroup filterGroup = new ToggleGroup();
////
////        ToggleButton all = createFilterButton("All", true);
////        ToggleButton todo = createFilterButton("To Do", false);
////        ToggleButton progress = createFilterButton("In Progress", false);
////        ToggleButton done = createFilterButton("Done", false);
////
////        all.setToggleGroup(filterGroup);
////        todo.setToggleGroup(filterGroup);
////        progress.setToggleGroup(filterGroup);
////        done.setToggleGroup(filterGroup);
////
////        box.getChildren().addAll(sortLabel, sortCombo, all, todo, progress, done);
////        return box;
////    }
////
////    private ToggleButton createFilterButton(String text, boolean selected) {
////        ToggleButton btn = new ToggleButton(text);
////        btn.setStyle(
////                selected ?
////                        "-fx-background-color: #2F81F7; -fx-text-fill: white;" :
////                        "-fx-background-color: transparent; -fx-text-fill: #A0A8B8;"
////        );
////        return btn;
////    }
////
////    // ==================== TASK CARD ====================
////    private VBox createTaskCard(String titleText, String priority, String description,
////                                String due, String category, boolean isSelected) {
////
////        VBox card = new VBox(12);
////        card.setPadding(new Insets(18));
////        card.setStyle(
////                "-fx-background-color: " + AppColors.CARD + ";" +
////                        "-fx-background-radius: 16;" +
////                        "-fx-border-color: " + (isSelected ? "#2F81F7" : "#2A2F3A") + ";" +
////                        "-fx-border-radius: 16;" +
////                        "-fx-border-width: " + (isSelected ? "2" : "1") + ";"
////        );
////
////        HBox header = new HBox(12);
////        Label title = new Label(titleText);
////        title.setFont(Font.font("System", FontWeight.BOLD, 17));
////        title.setTextFill(Color.WHITE);
////        HBox.setHgrow(title, Priority.ALWAYS);
////
////        Label prioLabel = new Label(priority);
////        prioLabel.setStyle(
////                "-fx-background-radius: 20; -fx-padding: 6 14;" +
////                        (priority.equals("URGENT") ? "-fx-background-color: #FF4D4D;" :
////                                priority.equals("HIGH") ? "-fx-background-color: #FFAA00;" :
////                                "-fx-background-color: #3B82F6;")
////        );
////        prioLabel.setTextFill(Color.WHITE);
////
////        header.getChildren().addAll(title, prioLabel);
////
////        Label desc = new Label(description);
////        desc.setWrapText(true);
////        desc.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
////        desc.setFont(Font.font("System", 13.5));
////
////        HBox footer = new HBox(15);
////        footer.setAlignment(Pos.CENTER_LEFT);
////
////        Label dueLabel = new Label("🗓 " + due);
////        dueLabel.setTextFill(Color.web(AppColors.PRIMARY));
////
////        Label catLabel = new Label("⚡ " + category);
////        catLabel.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
////
////        Region spacer = new Region();
////        HBox.setHgrow(spacer, Priority.ALWAYS);
////
////        footer.getChildren().addAll(dueLabel, catLabel, spacer);
////
////        // Avatars
////        HBox avatars = new HBox(-8);
////        // You can add Circle avatars here if needed
////
////        card.getChildren().addAll(header, desc, footer);
////        return card;
////    }
////
////    // ==================== SIDEBAR (نفس الـ PlansView) ====================
////    private VBox createSidebar() {
////        VBox box = new VBox(14);
////        box.setPadding(new Insets(25));
////        box.setPrefWidth(240);
////
////        box.setStyle(
////                "-fx-background-color: #151A21;" +
////                        "-fx-border-color: #222831;" +
////                        "-fx-border-width: 0 1 0 0;"
////        );
////
////        Label logo = new Label("PLANOVA");
////        logo.setTextFill(Color.WHITE);
////        logo.setFont(Font.font("System", FontWeight.BOLD, 24));
////
////        box.getChildren().addAll(
////                logo,
////                new Region() {{ setMinHeight(25); }},
////                navButton("Home"),
////                navButton("Plans"),
////                navButton("Progress"),
////                navButton("Tasks", true),   // Active
////                navButton("Analytics"),
////                navButton("Settings")
////        );
////
////        return box;
////    }
////
////    private Button navButton(String text) {
////        return navButton(text, false);
////    }
////
////    private Button navButton(String text, boolean active) {
////        Button btn = new Button(text);
////        btn.setPrefWidth(190);
////        btn.setPrefHeight(44);
////        btn.setAlignment(Pos.CENTER_LEFT);
////
////        String baseStyle = "-fx-background-color: " + (active ? "#1F2630" : "transparent") + ";" +
////                "-fx-text-fill: " + (active ? "white" : "#D6D6D6") + ";" +
////                "-fx-font-size: 14; -fx-background-radius: 10;";
////
////        btn.setStyle(baseStyle);
////
////        btn.setOnMouseEntered(e -> {
////            if (!active) btn.setStyle("-fx-background-color: #1F2630; -fx-text-fill: white; -fx-font-size:14; -fx-background-radius:10;");
////        });
////        btn.setOnMouseExited(e -> {
////            if (!active) btn.setStyle(baseStyle);
////        });
////
////        btn.setOnAction(e -> {
////            switch (text) {
////                case "Home" -> nav.goTo(new DashboardController(nav).getView());
////                case "Plans" -> nav.goTo(new PlansController(nav).getView());
////                case "Tasks" -> nav.goTo(new TasksController(nav).getView());
////                case "Analytics" -> nav.goTo(new AnalyticsController(nav).getView());
////                case "Settings" -> nav.goTo(new SettingsController(nav).getView());
////            }
////        });
////
////        return btn;
////    }
////}
//
//package com.example.planova.views;
//
//import com.example.planova.controllers.*;
//import com.example.planova.data.AppData;
//import com.example.planova.models.Task;
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
//public class TasksView {
//
//    private BorderPane root;
//    private VBox sidebar;
//    private VBox mainContent;
//    private VBox tasksList;
//
//    private NavigationController nav;
//
//    public TasksView(NavigationController nav) {
//        this.nav = nav;
//        createUI();
//    }
//
//    public Parent getView() {
//        return root;
//    }
//
//    private void createUI() {
//        root = new BorderPane();
//        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        sidebar = createSidebar();
//
//        mainContent = new VBox(20);
//        mainContent.setPadding(new Insets(25));
//        mainContent.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        // ==================== TOP BAR ====================
//        HBox topBar = createTopBar();
//
//        // ==================== HEADER ====================
//        HBox header = createHeader();
//
//        // ==================== TASKS LIST ====================
//        tasksList = new VBox(16);
//
//        loadTasks();   // تحميل المهام من AppData
//
//        mainContent.getChildren().addAll(topBar, header, tasksList);
//
//        ScrollPane scrollPane = new ScrollPane(mainContent);
//        scrollPane.setFitToWidth(true);
//        scrollPane.setStyle("-fx-background: " + AppColors.BACKGROUND + "; -fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        root.setLeft(sidebar);
//        root.setCenter(scrollPane);
//    }
//
//    private HBox createTopBar() {
//        HBox top = new HBox(20);
//        top.setAlignment(Pos.CENTER_LEFT);
//
//        TextField search = new TextField();
//        search.setPromptText("Search tasks...");
//        search.setPrefWidth(420);
//        search.setStyle(
//                "-fx-background-color: #1F2630;" +
//                        "-fx-text-fill: white;" +
//                        "-fx-prompt-text-fill: #7D8590;" +
//                        "-fx-background-radius: 12;" +
//                        "-fx-padding: 10;"
//        );
//
//        Region spacer = new Region();
//        HBox.setHgrow(spacer, Priority.ALWAYS);
//
//        top.getChildren().addAll(search, spacer);
//        return top;
//    }
//
//    private HBox createHeader() {
//        HBox header = new HBox(15);
//        header.setAlignment(Pos.CENTER_LEFT);
//
//        Label title = new Label("All Tasks");
//        title.setFont(Font.font("System", FontWeight.BOLD, 28));
//        title.setTextFill(Color.WHITE);
//
//        Region spacer = new Region();
//        HBox.setHgrow(spacer, Priority.ALWAYS);
//
//        Label stats = new Label("Total Tasks: " + getTotalTasksCount());
//        stats.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        header.getChildren().addAll(title, spacer, stats);
//        return header;
//    }
//
//    private void loadTasks() {
//        tasksList.getChildren().clear();
//
//        // لو فيه بلان حالي، نعرض مهامه
//        if (AppData.currentPlan != null && !AppData.currentPlan.getTasks().isEmpty()) {
//            for (Task task : AppData.currentPlan.getTasks()) {
//                tasksList.getChildren().add(createTaskCard(task));
//            }
//        }
//        // لو مفيش، نعرض بعض المهام الافتراضية
//        else {
//            tasksList.getChildren().addAll(
//                    createTaskCard("Design System Architecture Refresh", "HIGH",
//                            "Consolidate the token system...", "Today, 5:00 PM", "Engineering"),
//                    createTaskCard("Update API Documentation", "MEDIUM",
//                            "Refactor the endpoint descriptions...", "Jun 12", "Documentation"),
//                    createTaskCard("Prepare Investor Q3 Deck", "URGENT",
//                            "Compile analytics growth charts...", "Jun 15", "Strategy")
//            );
//        }
//    }
//
//    private VBox createTaskCard(Task task) {
//        return createTaskCard(task.getTitle(), "MEDIUM", task.getDescription() != null ? task.getDescription() : "",
//                "Today", task.getCategory());
//    }
//
//    private VBox createTaskCard(String titleText, String priority, String description,
//                                String due, String category) {
//        VBox card = new VBox(12);
//        card.setPadding(new Insets(18));
//        card.setStyle(
//                "-fx-background-color: " + AppColors.CARD + ";" +
//                        "-fx-background-radius: 16;" +
//                        "-fx-border-color: #2A2F3A;" +
//                        "-fx-border-radius: 16;"
//        );
//
//        HBox header = new HBox(12);
//        Label title = new Label(titleText);
//        title.setFont(Font.font("System", FontWeight.BOLD, 17));
//        title.setTextFill(Color.WHITE);
//        HBox.setHgrow(title, Priority.ALWAYS);
//
//        Label prioLabel = new Label(priority);
//        prioLabel.setStyle("-fx-background-radius: 20; -fx-padding: 6 14; -fx-background-color: #FFAA00;");
//        prioLabel.setTextFill(Color.WHITE);
//
//        header.getChildren().addAll(title, prioLabel);
//
//        Label desc = new Label(description);
//        desc.setWrapText(true);
//        desc.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//        desc.setFont(Font.font("System", 13.5));
//
//        HBox footer = new HBox(15);
//        footer.setAlignment(Pos.CENTER_LEFT);
//
//        Label dueLabel = new Label("🗓 " + due);
//        dueLabel.setTextFill(Color.web(AppColors.PRIMARY));
//
//        Label catLabel = new Label("⚡ " + category);
//        catLabel.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        footer.getChildren().addAll(dueLabel, catLabel);
//
//        card.getChildren().addAll(header, desc, footer);
//        return card;
//    }
//
//    private int getTotalTasksCount() {
//        if (AppData.currentPlan != null) {
//            return AppData.currentPlan.getTasks().size();
//        }
//        return 12; // قيمة افتراضية
//    }
//
//    // ==================== SIDEBAR ====================
//    private VBox createSidebar() {
//        VBox box = new VBox(14);
//        box.setPadding(new Insets(25));
//        box.setPrefWidth(240);
//
//        box.setStyle(
//                "-fx-background-color: #151A21;" +
//                        "-fx-border-color: #222831;" +
//                        "-fx-border-width: 0 1 0 0;"
//        );
//
//        Label logo = new Label("PLANOVA");
//        logo.setTextFill(Color.WHITE);
//        logo.setFont(Font.font("System", FontWeight.BOLD, 24));
//
//        box.getChildren().addAll(
//                logo,
//                new Region() {{ setMinHeight(25); }},
//                navButton("Home"),
//                navButton("Plans"),
//                navButton("Tasks", true),   // Active
//                navButton("Analytics"),
//                navButton("Settings")
//        );
//
//        return box;
//    }
//
//    private Button navButton(String text) {
//        return navButton(text, false);
//    }
//
//    private Button navButton(String text, boolean active) {
//        Button btn = new Button(text);
//        btn.setPrefWidth(190);
//        btn.setPrefHeight(44);
//        btn.setAlignment(Pos.CENTER_LEFT);
//
//        String baseStyle = "-fx-background-color: " + (active ? "#1F2630" : "transparent") + ";" +
//                "-fx-text-fill: " + (active ? "white" : "#D6D6D6") + ";" +
//                "-fx-font-size: 14; -fx-background-radius: 10;";
//
//        btn.setStyle(baseStyle);
//
//        btn.setOnMouseEntered(e -> {
//            if (!active) btn.setStyle("-fx-background-color: #1F2630; -fx-text-fill: white; -fx-font-size:14; -fx-background-radius:10;");
//        });
//        btn.setOnMouseExited(e -> {
//            if (!active) btn.setStyle(baseStyle);
//        });
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
//}

package com.example.planova.views;

import com.example.planova.controllers.*;
import com.example.planova.data.AppData;
import com.example.planova.models.Task;
import com.example.planova.styles.AppColors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TasksView {

    private BorderPane root;
    private VBox sidebar;
    private VBox mainContent;
    private VBox tasksList;

    private NavigationController nav;

    public TasksView(NavigationController nav) {
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

        // ==================== HEADER ====================
        HBox header = createHeader();

        // ==================== TASKS LIST ====================
        tasksList = new VBox(16);
        loadTasks();

        mainContent.getChildren().addAll(topBar, header, tasksList);

        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle(
                "-fx-background:" + AppColors.BACKGROUND + ";" +
                        "-fx-background-color:" + AppColors.BACKGROUND + ";"
        );

        root.setLeft(sidebar);
        root.setCenter(scrollPane);
    }

    private HBox createTopBar() {
        HBox top = new HBox(20);
        top.setAlignment(Pos.CENTER_LEFT);

        TextField search = new TextField();
        search.setPromptText("Search tasks...");
        search.setPrefWidth(420);
        search.setStyle(
                "-fx-background-color: #1F2630;" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: #7D8590;" +
                        "-fx-background-radius: 12;" +
                        "-fx-padding: 10;"
        );

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        top.getChildren().addAll(search, spacer);
        return top;
    }

    private HBox createHeader() {
        HBox header = new HBox(15);
        header.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("All Tasks");
        title.setFont(Font.font("System", FontWeight.BOLD, 28));
        title.setTextFill(Color.WHITE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label stats = new Label("Total Tasks: " + getTotalTasksCount());
        stats.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        header.getChildren().addAll(title, spacer, stats);
        return header;
    }

    private void loadTasks() {
        tasksList.getChildren().clear();

        if (AppData.currentPlan != null && !AppData.currentPlan.getTasks().isEmpty()) {
            for (Task task : AppData.currentPlan.getTasks()) {
                tasksList.getChildren().add(createTaskCard(task));
            }
        } else {
            // Default tasks
            tasksList.getChildren().addAll(
                    createTaskCard("Design System Architecture Refresh", "HIGH",
                            "Consolidate the token system and update the layout components...",
                            "Today, 5:00 PM", "Engineering"),
                    createTaskCard("Update API Documentation", "MEDIUM",
                            "Refactor the endpoint descriptions for the new productivity suite...",
                            "Jun 12", "Documentation"),
                    createTaskCard("Prepare Investor Q3 Deck", "URGENT",
                            "Compile the analytics growth charts and upcoming feature roadmap...",
                            "Jun 15", "Strategy")
            );
        }
    }

    private VBox createTaskCard(Task task) {
        return createTaskCard(task.getTitle(), "MEDIUM",
                task.getDescription() != null ? task.getDescription() : "No description",
                "Today", task.getCategory());
    }

    private VBox createTaskCard(String titleText, String priority, String description,
                                String due, String category) {
        VBox card = new VBox(12);
        card.setPadding(new Insets(18));
        card.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 16;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 16;"
        );

        HBox header = new HBox(12);
        Label title = new Label(titleText);
        title.setFont(Font.font("System", FontWeight.BOLD, 17));
        title.setTextFill(Color.WHITE);
        HBox.setHgrow(title, Priority.ALWAYS);

        Label prioLabel = new Label(priority);
        prioLabel.setStyle(
                "-fx-background-radius: 20; -fx-padding: 6 14; " +
                        (priority.equals("URGENT") ? "-fx-background-color: #FF4D4D;" :
                                priority.equals("HIGH") ? "-fx-background-color: #FFAA00;" :
                                "-fx-background-color: #3B82F6;")
        );
        prioLabel.setTextFill(Color.WHITE);

        header.getChildren().addAll(title, prioLabel);

        Label desc = new Label(description);
        desc.setWrapText(true);
        desc.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
        desc.setFont(Font.font("System", 13.5));

        HBox footer = new HBox(15);
        footer.setAlignment(Pos.CENTER_LEFT);

        Label dueLabel = new Label("🗓 " + due);
        dueLabel.setTextFill(Color.web(AppColors.PRIMARY));

        Label catLabel = new Label("⚡ " + category);
        catLabel.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        footer.getChildren().addAll(dueLabel, catLabel);

        card.getChildren().addAll(header, desc, footer);
        return card;
    }

    private int getTotalTasksCount() {
        if (AppData.currentPlan != null) {
            return AppData.currentPlan.getTasks().size();
        }
        return 8;
    }

    //================================================
    // SIDEBAR (نفس الستايل الموحد)
    //================================================
    private VBox createSidebar() {
        VBox box = new VBox(14);
        box.setPadding(new Insets(25));
        box.setPrefWidth(240);

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
                navButton("Tasks", true),   // Active
                navButton("Analytics"),
                navButton("Settings")
        );

        return box;
    }

    private Button navButton(String text) {
        return navButton(text, false);
    }

    private Button navButton(String text, boolean active) {
        Button btn = new Button(text);
        btn.setPrefWidth(190);
        btn.setPrefHeight(44);
        btn.setAlignment(Pos.CENTER_LEFT);

        String baseStyle = "-fx-background-color: " + (active ? "#1F2630" : "transparent") + ";" +
                "-fx-text-fill: " + (active ? "white" : "#D6D6D6") + ";" +
                "-fx-font-size: 14; -fx-background-radius: 10;";

        btn.setStyle(baseStyle);

        btn.setOnMouseEntered(e -> {
            if (!active) btn.setStyle("-fx-background-color: #1F2630; -fx-text-fill: white; -fx-font-size:14; -fx-background-radius:10;");
        });
        btn.setOnMouseExited(e -> {
            if (!active) btn.setStyle(baseStyle);
        });

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
}
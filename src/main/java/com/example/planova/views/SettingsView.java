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
//public class SettingsView {
//
//    private BorderPane root;
//    private VBox sidebar;
//    private VBox content;
//
//    private NavigationController nav;
//
//    public SettingsView(NavigationController nav) {
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
//        content = new VBox(22);
//        content.setPadding(new Insets(40, 70, 40, 70));
//        content.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        // Title
//        Label title = new Label("Settings");
//        title.setFont(Font.font("System", FontWeight.BOLD, 30));
//        title.setTextFill(Color.WHITE);
//
//        Label sub = new Label("Manage your account preferences and system behavior");
//        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        VBox header = new VBox(5, title, sub);
//
//        // Card Style
//        String cardStyle = "-fx-background-color: " + AppColors.CARD + ";" +
//                "-fx-background-radius: 18;" +
//                "-fx-border-color: #2A2F3A;" +
//                "-fx-border-radius: 18;";
//
//        Insets pad = new Insets(18);
//
//        // Profile Card
//        VBox profileCard = createProfileCard(cardStyle, pad);
//
//        // Appearance Card
//        VBox appearanceCard = createAppearanceCard(cardStyle, pad);
//
//        // Notifications Card
//        VBox notifCard = createNotificationsCard(cardStyle, pad);
//
//        // Productivity Card
//        VBox prodCard = createProductivityCard(cardStyle, pad);
//
//        // Account Actions
//        VBox accountCard = createAccountCard(cardStyle, pad);
//
//        content.getChildren().addAll(
//                header,
//                profileCard,
//                appearanceCard,
//                notifCard,
//                prodCard,
//                accountCard
//        );
//
//        ScrollPane scrollPane = new ScrollPane(content);
//        scrollPane.setFitToWidth(true);
//        scrollPane.setStyle("-fx-background:" + AppColors.BACKGROUND + "; -fx-background-color: " + AppColors.BACKGROUND + ";");
//
//        root.setLeft(sidebar);
//        root.setCenter(scrollPane);
//    }
//
//    //================================================
//    // SIDEBAR (نفس الستايل الموحد)
//    //================================================
//    private VBox createSidebar() {
//        VBox box = new VBox(14);
//        box.setPadding(new Insets(25));
//        box.setPrefWidth(240);
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
//                navButton("Settings", true)   // Active
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
//
//    //================================================
//    // CARDS
//    //================================================
//    private VBox createProfileCard(String cardStyle, Insets pad) {
//        VBox card = new VBox(12);
//        card.setPadding(pad);
//        card.setStyle(cardStyle);
//
//        Label profileTitle = sectionTitle("Profile");
//        Label name = new Label("Alex Johnson");
//        name.setTextFill(Color.WHITE);
//        name.setFont(Font.font(18));
//
//        Label email = new Label("alex@planova.app");
//        email.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        Button editProfile = primaryButton("Edit Profile");
//        editProfile.setOnAction(e -> nav.goTo(new EditProfileView(nav).getView()));
//
//        card.getChildren().addAll(profileTitle, name, email, editProfile);
//        return card;
//    }
//
//    private VBox createAppearanceCard(String cardStyle, Insets pad) {
//        VBox card = new VBox(12);
//        card.setPadding(pad);
//        card.setStyle(cardStyle);
//
//        Label title = sectionTitle("Appearance");
//        CheckBox darkMode = new CheckBox("Dark Mode (Default)");
//        darkMode.setTextFill(Color.WHITE);
//        darkMode.setSelected(true);
//
//        CheckBox compactMode = new CheckBox("Compact Layout");
//        compactMode.setTextFill(Color.WHITE);
//
//        card.getChildren().addAll(title, darkMode, compactMode);
//        return card;
//    }
//
//    private VBox createNotificationsCard(String cardStyle, Insets pad) {
//        VBox card = new VBox(12);
//        card.setPadding(pad);
//        card.setStyle(cardStyle);
//
//        Label title = sectionTitle("Notifications");
//
//        CheckBox emailNotif = new CheckBox("Email Notifications");
//        emailNotif.setTextFill(Color.WHITE);
//        emailNotif.setSelected(true);
//
//        CheckBox pushNotif = new CheckBox("Push Notifications");
//        pushNotif.setTextFill(Color.WHITE);
//
//        CheckBox weeklyReport = new CheckBox("Weekly Productivity Report");
//        weeklyReport.setTextFill(Color.WHITE);
//        weeklyReport.setSelected(true);
//
//        card.getChildren().addAll(title, emailNotif, pushNotif, weeklyReport);
//        return card;
//    }
//
//    private VBox createProductivityCard(String cardStyle, Insets pad) {
//        VBox card = new VBox(12);
//        card.setPadding(pad);
//        card.setStyle(cardStyle);
//
//        Label title = sectionTitle("Productivity Preferences");
//
//        Label focusLabel = new Label("Default Focus Mode");
//        focusLabel.setTextFill(Color.WHITE);
//
//        ComboBox<String> focusMode = new ComboBox<>();
//        focusMode.getItems().addAll("Deep Work", "Balanced", "Light Mode");
//        focusMode.setValue("Balanced");
//        focusMode.setStyle("-fx-background-color:#1F2630; -fx-text-fill:white; -fx-background-radius:10;");
//
//        Label startHour = new Label("Work Start Reminder");
//        startHour.setTextFill(Color.WHITE);
//
//        Spinner<Integer> startTime = new Spinner<>(0, 23, 9);
//        startTime.setPrefWidth(100);
//        startTime.setStyle("-fx-background-color:#1F2630; -fx-background-radius:10; -fx-border-color:#2A2F3A;");
//
//        card.getChildren().addAll(title, focusLabel, focusMode, startHour, startTime);
//        return card;
//    }
//
//    private VBox createAccountCard(String cardStyle, Insets pad) {
//        VBox card = new VBox(12);
//        card.setPadding(pad);
//        card.setStyle(cardStyle);
//
//        Label title = sectionTitle("Account");
//
//        Button exportData = secondaryButton("Export My Data");
//
//        Button logout = dangerButton("Log Out");
//        logout.setOnAction(e -> nav.goTo(new LoginView(nav).getView()));
//
//        card.getChildren().addAll(title, exportData, logout);
//        return card;
//    }
//
//    //================================================
//    // HELPERS
//    //================================================
//    private Label sectionTitle(String text) {
//        Label l = new Label(text);
//        l.setTextFill(Color.WHITE);
//        l.setFont(Font.font("System", FontWeight.BOLD, 18));
//        return l;
//    }
//
//    private Button primaryButton(String text) {
//        Button b = new Button(text);
//        b.setStyle("-fx-background-color:#2F81F7; -fx-text-fill:white; -fx-background-radius:10;");
//        return b;
//    }
//
//    private Button secondaryButton(String text) {
//        Button b = new Button(text);
//        b.setStyle("-fx-background-color:#1F2630; -fx-text-fill:white; -fx-background-radius:10; -fx-border-color:#2A2F3A; -fx-border-radius:10;");
//        return b;
//    }
//
//    private Button dangerButton(String text) {
//        Button b = new Button(text);
//        b.setStyle("-fx-background-color:#D64545; -fx-text-fill:white; -fx-background-radius:10;");
//        return b;
//    }
//}

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

public class SettingsView {

    private BorderPane root;
    private VBox sidebar;
    private VBox content;

    private NavigationController nav;
    private SettingsController controller;

    public SettingsView(NavigationController nav) {
        this.nav = nav;
        createUI();
    }

    // Setter للـ Controller
    public void setController(SettingsController controller) {
        this.controller = controller;
    }

    public Parent getView() {
        return root;
    }

    private void createUI() {
        root = new BorderPane();
        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        sidebar = createSidebar();

        content = new VBox(22);
        content.setPadding(new Insets(40, 70, 40, 70));
        content.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        // Title
        Label title = new Label("Settings");
        title.setFont(Font.font("System", FontWeight.BOLD, 30));
        title.setTextFill(Color.WHITE);

        Label sub = new Label("Manage your account preferences and system behavior");
        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        VBox header = new VBox(5, title, sub);

        String cardStyle = "-fx-background-color: " + AppColors.CARD + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #2A2F3A;" +
                "-fx-border-radius: 18;";

        Insets pad = new Insets(18);

        // Cards
        VBox profileCard = createProfileCard(cardStyle, pad);
        VBox appearanceCard = createAppearanceCard(cardStyle, pad);
        VBox notifCard = createNotificationsCard(cardStyle, pad);
        VBox prodCard = createProductivityCard(cardStyle, pad);
        VBox accountCard = createAccountCard(cardStyle, pad);

        content.getChildren().addAll(
                header,
                profileCard,
                appearanceCard,
                notifCard,
                prodCard,
                accountCard
        );

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background:" + AppColors.BACKGROUND + "; -fx-background-color: " + AppColors.BACKGROUND + ";");

        root.setLeft(sidebar);
        root.setCenter(scrollPane);
    }

    //================================================
    // SIDEBAR
    //================================================
    private VBox createSidebar() {
        VBox box = new VBox(14);
        box.setPadding(new Insets(25));
        box.setPrefWidth(240);

        box.setStyle("-fx-background-color:#151A21; -fx-border-color:#222831; -fx-border-width:0 1 0 0;");

        Label logo = new Label("PLANOVA");
        logo.setTextFill(Color.WHITE);
        logo.setFont(Font.font("System", FontWeight.BOLD, 22));

        Region space = new Region();
        space.setMinHeight(18);

        box.getChildren().addAll(
                logo, space,
                navButton("Home"),
                navButton("Plans"),
                navButton("Tasks"),
                navButton("Analytics"),
                navButton("Settings", true)   // Active
        );

        return box;
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

    private Button navButton(String text) {
        return navButton(text, false);
    }

    //================================================
    // CARDS
    //================================================
    private VBox createProfileCard(String cardStyle, Insets pad) {
        VBox card = new VBox(12);
        card.setPadding(pad);
        card.setStyle(cardStyle);

        Label title = sectionTitle("Profile");
        Label name = new Label("Alex Johnson");
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font(18));

        Label email = new Label("alex@planova.app");
        email.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Button editProfile = primaryButton("Edit Profile");
        editProfile.setOnAction(e -> nav.goTo(new EditProfileView(nav).getView()));

        card.getChildren().addAll(title, name, email, editProfile);
        return card;
    }

    private VBox createAppearanceCard(String cardStyle, Insets pad) {
        VBox card = new VBox(12);
        card.setPadding(pad);
        card.setStyle(cardStyle);

        Label title = sectionTitle("Appearance");

        CheckBox darkMode = new CheckBox("Dark Mode (Default)");
        darkMode.setTextFill(Color.WHITE);
        darkMode.setSelected(true);

        CheckBox compactMode = new CheckBox("Compact Layout");
        compactMode.setTextFill(Color.WHITE);

        card.getChildren().addAll(title, darkMode, compactMode);
        return card;
    }

    private VBox createNotificationsCard(String cardStyle, Insets pad) {
        VBox card = new VBox(12);
        card.setPadding(pad);
        card.setStyle(cardStyle);

        Label title = sectionTitle("Notifications");

        CheckBox emailNotif = new CheckBox("Email Notifications");
        emailNotif.setTextFill(Color.WHITE);
        emailNotif.setSelected(true);

        CheckBox pushNotif = new CheckBox("Push Notifications");
        pushNotif.setTextFill(Color.WHITE);

        CheckBox weeklyReport = new CheckBox("Weekly Productivity Report");
        weeklyReport.setTextFill(Color.WHITE);
        weeklyReport.setSelected(true);

        card.getChildren().addAll(title, emailNotif, pushNotif, weeklyReport);
        return card;
    }

    private VBox createProductivityCard(String cardStyle, Insets pad) {
        VBox card = new VBox(12);
        card.setPadding(pad);
        card.setStyle(cardStyle);

        Label title = sectionTitle("Productivity Preferences");

        Label focusLabel = new Label("Default Focus Mode");
        focusLabel.setTextFill(Color.WHITE);

        ComboBox<String> focusMode = new ComboBox<>();
        focusMode.getItems().addAll("Deep Work", "Balanced", "Light Mode");
        focusMode.setValue("Balanced");
        focusMode.setStyle("-fx-background-color:#1F2630; -fx-text-fill:white; -fx-background-radius:10;");

        Label startHour = new Label("Work Start Reminder");
        startHour.setTextFill(Color.WHITE);

        Spinner<Integer> startTime = new Spinner<>(0, 23, 9);
        startTime.setPrefWidth(100);
        startTime.setStyle("-fx-background-color:#1F2630; -fx-background-radius:10; -fx-border-color:#2A2F3A;");

        card.getChildren().addAll(title, focusLabel, focusMode, startHour, startTime);

        // ربط الـ Controls مع الـ Controller
        if (controller != null) {
            controller.setControls(null, null, null, null, null, focusMode, startTime);
        }

        return card;
    }

    private VBox createAccountCard(String cardStyle, Insets pad) {
        VBox card = new VBox(12);
        card.setPadding(pad);
        card.setStyle(cardStyle);

        Label title = sectionTitle("Account");

        Button exportData = secondaryButton("Export My Data");

        Button logout = dangerButton("Log Out");
        logout.setOnAction(e -> {
            if (controller != null) {
                controller.logout();
            } else {
                nav.goTo(new LoginView(nav).getView());
            }
        });

        card.getChildren().addAll(title, exportData, logout);
        return card;
    }

    //================================================
    // HELPERS
    //================================================
    private Label sectionTitle(String text) {
        Label l = new Label(text);
        l.setTextFill(Color.WHITE);
        l.setFont(Font.font("System", FontWeight.BOLD, 18));
        return l;
    }

    private Button primaryButton(String text) {
        Button b = new Button(text);
        b.setStyle("-fx-background-color:#2F81F7; -fx-text-fill:white; -fx-background-radius:10;");
        return b;
    }

    private Button secondaryButton(String text) {
        Button b = new Button(text);
        b.setStyle("-fx-background-color:#1F2630; -fx-text-fill:white; -fx-background-radius:10; -fx-border-color:#2A2F3A; -fx-border-radius:10;");
        return b;
    }

    private Button dangerButton(String text) {
        Button b = new Button(text);
        b.setStyle("-fx-background-color:#D64545; -fx-text-fill:white; -fx-background-radius:10;");
        return b;
    }
}
//package com.example.planova.views;
//import com.example.planova.data.AppData;
//import com.example.planova.styles.AppColors;
//import javafx.collections.FXCollections;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import com.example.planova.controllers.NavigationController;
//
//public class SetupView {
//
//    private ScrollPane root;
//    private VBox content;
//    private NavigationController navigationController;
//
//    public SetupView(NavigationController nav) {
//        this.navigationController = nav;
//        createUI();
//    }
//
//    public Parent getView() {
//        return root;
//    }
//
//    private void createUI() {
//
//        //--------------------------------
//        // Content Container
//        //--------------------------------
//        content = new VBox(26);
//        content.setAlignment(Pos.TOP_CENTER);
//        content.setPadding(new Insets(50, 80, 50, 80));
//
//        content.setStyle(
//                "-fx-background-color: " + AppColors.BACKGROUND + ";"
//        );
//
//        //--------------------------------
//        // ScrollPane
//        //--------------------------------
//        root = new ScrollPane(content);
//        root.setFitToWidth(true);
//
//        root.setStyle(
//                "-fx-background: " + AppColors.BACKGROUND + ";" +
//                        "-fx-background-color: " + AppColors.BACKGROUND + ";"
//        );
//
//        //--------------------------------
//        // HEADER
//        //--------------------------------
//        Label logo = new Label("PlanNova");
//        logo.setFont(Font.font("System", FontWeight.BOLD, 32));
//        logo.setTextFill(Color.WHITE);
//
//        Label title = new Label("Personalize Your Experience");
//        title.setFont(Font.font("System", FontWeight.BOLD, 26));
//        title.setTextFill(Color.WHITE);
//
//        Label subtitle = new Label("Let’s set up your productivity profile in a few steps");
//        subtitle.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        VBox header = new VBox(6, logo, title, subtitle);
//        header.setAlignment(Pos.CENTER);
//
//        //--------------------------------
//        // CARD STYLE
//        //--------------------------------
//        String cardStyle =
//                "-fx-background-color: " + AppColors.CARD + ";" +
//                        "-fx-background-radius: 18;" +
//                        "-fx-border-color: #2A2F3A;" +
//                        "-fx-border-radius: 18;";
//
//        Insets cardPadding = new Insets(20);
//
//        //--------------------------------
//        // PLAN TYPE
//        //--------------------------------
//        VBox planCard = new VBox(12);
//        planCard.setPadding(cardPadding);
//        planCard.setStyle(cardStyle);
//
//        Label planLabel = sectionTitle("Plan Type");
//
//        HBox planRow = new HBox(12);
//        planRow.setAlignment(Pos.CENTER);
//
//        ToggleGroup planGroup = new ToggleGroup();
//
//        String[] plans = {"Balanced", "Deep Focused", "Relaxed"};
//
//        for (String plan : plans) {
//
//            ToggleButton btn = new ToggleButton(plan);
//            btn.setToggleGroup(planGroup);
//            btn.setPrefSize(150, 44);
//            btn.setStyle(unselectedToggle());
//
//            btn.setOnAction(e -> {
//                AppData.setupData.setPlanType(plan);
//                btn.setStyle(selectedToggle());
//            });
//
//            planRow.getChildren().add(btn);
//        }
//
//        planCard.getChildren().addAll(planLabel, planRow);
//
//        //--------------------------------
//        // DAYS
//        //--------------------------------
//        VBox daysCard = new VBox(12);
//        daysCard.setPadding(cardPadding);
//        daysCard.setStyle(cardStyle);
//
//        Label daysLabel = sectionTitle("Available Days");
//
//        HBox daysRow = new HBox(10);
//        daysRow.setAlignment(Pos.CENTER);
//
//        String[] days = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
//
//        for (String day : days) {
//
//            ToggleButton btn = new ToggleButton(day);
//            btn.setPrefSize(70, 40);
//            btn.setStyle(unselectedToggle());
//
//            btn.setOnAction(e -> btn.setStyle(selectedToggle()));
//
//            daysRow.getChildren().add(btn);
//        }
//
//        daysCard.getChildren().addAll(daysLabel, daysRow);
//
//        //--------------------------------
//        // FREE HOURS
//        //--------------------------------
//        VBox hoursCard = new VBox(12);
//        hoursCard.setPadding(cardPadding);
//        hoursCard.setStyle(cardStyle);
//
//        Label hoursLabel = sectionTitle("Free Hours Per Day");
//
//        VBox hoursBox = new VBox(10);
//
//        String[] freeDays = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
//
//        for (String day : freeDays) {
//
//            HBox row = new HBox(15);
//            row.setAlignment(Pos.CENTER_LEFT);
//
//            Label d = new Label(day);
//            d.setTextFill(Color.WHITE);
//            d.setPrefWidth(60);
//
//            Spinner<Integer> spinner = new Spinner<>(0, 24, 4);
//            spinner.setPrefWidth(90);
//
//            AppData.setupData.getFreeHoursPerDay().put(day, 4);
//
//            spinner.valueProperty().addListener((obs, oldV, newV) ->
//                    AppData.setupData.getFreeHoursPerDay().put(day, newV)
//            );
//
//            row.getChildren().addAll(d, spinner);
//            hoursBox.getChildren().add(row);
//        }
//
//        hoursCard.getChildren().addAll(hoursLabel, hoursBox);
//
//        //--------------------------------
//        // BUTTON (FIXED NAVIGATION)
//        //--------------------------------
//        Button btn = new Button("Go To Dashboard");
//
//        btn.setPrefSize(260, 48);
//
//        btn.setStyle(
//                "-fx-background-color: " + AppColors.PRIMARY + ";" +
//                        "-fx-text-fill: white;" +
//                        "-fx-font-size: 14;" +
//                        "-fx-font-weight: bold;" +
//                        "-fx-background-radius: 12;"
//        );
//
//        btn.setOnAction(e -> {
//
//            AppData.setupData.printData();
//
//            // ✅ FIX: unified navigation system
//            navigationController.goTo(
//                    new com.example.planova.views.DashboardView(navigationController).getView()
//            );
//        });
//
//        //--------------------------------
//        // FOOTER
//        //--------------------------------
//        Label footer = new Label("STEP 1 OF 3 — SETUP COMPLETE PROFILE");
//        footer.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
//
//        //--------------------------------
//        // ADD ALL
//        //--------------------------------
//        content.getChildren().addAll(
//                header,
//                planCard,
//                daysCard,
//                hoursCard,
//                btn,
//                footer
//        );
//    }
//
//    //--------------------------------
//    // HELPERS
//    //--------------------------------
//
//    private Label sectionTitle(String text) {
//        Label l = new Label(text);
//        l.setTextFill(Color.WHITE);
//        l.setFont(Font.font("System", FontWeight.BOLD, 18));
//        return l;
//    }
//
//    private String unselectedToggle() {
//        return "-fx-background-color:#21262D;" +
//                "-fx-text-fill:white;" +
//                "-fx-background-radius:10;" +
//                "-fx-border-color:#2A2F3A;" +
//                "-fx-border-radius:10;";
//    }
//
//    private String selectedToggle() {
//        return "-fx-background-color:#2F81F7;" +
//                "-fx-text-fill:white;" +
//                "-fx-background-radius:10;";
//    }
//}

package com.example.planova.views;

import com.example.planova.controllers.NavigationController;
import com.example.planova.controllers.SetupController;
import com.example.planova.data.AppData;
import com.example.planova.styles.AppColors;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SetupView {

    private ScrollPane root;

    private VBox content;

    private NavigationController navigationController;

    private SetupController controller;

    public SetupView(
            NavigationController nav
    ) {

        this.navigationController = nav;

        controller = new SetupController();

        createUI();
    }

    public Parent getView() {

        return root;
    }

    private void createUI() {

        //--------------------------------
        // Content
        //--------------------------------
        content = new VBox(26);

        content.setAlignment(Pos.TOP_CENTER);

        content.setPadding(
                new Insets(50, 80, 50, 80)
        );

        content.setStyle(
                "-fx-background-color: " +
                        AppColors.BACKGROUND + ";"
        );

        //--------------------------------
        // Scroll
        //--------------------------------
        root = new ScrollPane(content);

        root.setFitToWidth(true);

        root.setStyle(
                "-fx-background: " +
                        AppColors.BACKGROUND + ";" +

                        "-fx-background-color: " +
                        AppColors.BACKGROUND + ";"
        );

        //--------------------------------
        // Header
        //--------------------------------
        Label logo = new Label("PlanNova");

        logo.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        32
                )
        );

        logo.setTextFill(Color.WHITE);

        Label title =
                new Label(
                        "Personalize Your Experience"
                );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        26
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle =
                new Label(
                        "Let's set up your productivity profile"
                );

        subtitle.setTextFill(
                Color.web(
                        AppColors.SECONDARY_TEXT
                )
        );

        VBox header = new VBox(
                6,
                logo,
                title,
                subtitle
        );

        header.setAlignment(Pos.CENTER);

        //--------------------------------
        // Card Style
        //--------------------------------
        String cardStyle =

                "-fx-background-color: " +
                        AppColors.CARD + ";" +

                        "-fx-background-radius: 18;" +

                        "-fx-border-color: #2A2F3A;" +

                        "-fx-border-radius: 18;";

        Insets cardPadding =
                new Insets(20);

        //--------------------------------
        // PLAN TYPE
        //--------------------------------
        VBox planCard = new VBox(12);

        planCard.setPadding(cardPadding);

        planCard.setStyle(cardStyle);

        Label planLabel =
                sectionTitle("Plan Type");

        HBox planRow = new HBox(12);

        planRow.setAlignment(Pos.CENTER);

        ToggleGroup planGroup =
                new ToggleGroup();

        String[] plans = {
                "Balanced",
                "Deep Focused",
                "Relaxed"
        };

        for (String plan : plans) {

            ToggleButton btn =
                    new ToggleButton(plan);

            btn.setToggleGroup(planGroup);

            btn.setPrefSize(150, 44);

            btn.setStyle(unselectedToggle());

            btn.setOnAction(e -> {

                for (Toggle toggle :
                        planGroup.getToggles()) {

                    ToggleButton b =
                            (ToggleButton) toggle;

                    b.setStyle(
                            unselectedToggle()
                    );
                }

                btn.setStyle(
                        selectedToggle()
                );

                controller.setPlanType(plan);
            });

            if (plan.equals("Balanced")) {

                btn.setSelected(true);

                btn.setStyle(
                        selectedToggle()
                );
            }

            planRow.getChildren()
                    .add(btn);
        }

        planCard.getChildren()
                .addAll(
                        planLabel,
                        planRow
                );

        //--------------------------------
        // DAYS
        //--------------------------------
        VBox daysCard = new VBox(12);

        daysCard.setPadding(cardPadding);

        daysCard.setStyle(cardStyle);

        Label daysLabel =
                sectionTitle(
                        "Available Days"
                );

        HBox daysRow = new HBox(10);

        daysRow.setAlignment(Pos.CENTER);

        String[] days = {
                "Mon","Tue","Wed",
                "Thu","Fri","Sat","Sun"
        };

        for (String day : days) {

            ToggleButton btn =
                    new ToggleButton(day);

            btn.setPrefSize(70, 40);

            btn.setStyle(
                    selectedToggle()
            );

            btn.setSelected(true);

            btn.setOnAction(e -> {

                if (btn.isSelected()) {

                    btn.setStyle(
                            selectedToggle()
                    );

                    AppData.setupData
                            .getAvailableDays()
                            .add(day);

                } else {

                    btn.setStyle(
                            unselectedToggle()
                    );

                    AppData.setupData
                            .getAvailableDays()
                            .remove(day);
                }
            });

            daysRow.getChildren()
                    .add(btn);
        }

        daysCard.getChildren()
                .addAll(
                        daysLabel,
                        daysRow
                );

        //--------------------------------
        // FREE HOURS
        //--------------------------------
        VBox hoursCard = new VBox(16);

        hoursCard.setPadding(cardPadding);

        hoursCard.setStyle(cardStyle);

        Label hoursLabel =
                sectionTitle(
                        "Free Hours Per Day"
                );

        GridPane grid = new GridPane();

        grid.setHgap(30);

        grid.setVgap(15);

        String[] freeDays = {
                "Mon","Tue","Wed",
                "Thu","Fri","Sat","Sun"
        };

        int col = 0;
        int row = 0;

        for (String day : freeDays) {

            HBox item = new HBox(12);

            item.setAlignment(
                    Pos.CENTER_LEFT
            );

            Label d = new Label(day);

            d.setTextFill(Color.WHITE);

            d.setPrefWidth(45);

            Spinner<Integer> spinner =
                    new Spinner<>(0, 24, 4);

            spinner.setPrefWidth(100);

            spinner.valueProperty()
                    .addListener(
                            (obs, oldV, newV) ->

                                    controller
                                            .setFreeHours(
                                                    day,
                                                    newV
                                            )
                    );

            item.getChildren()
                    .addAll(d, spinner);

            grid.add(item, col, row);

            col++;

            if (col == 2) {

                col = 0;

                row++;
            }
        }

        hoursCard.getChildren()
                .addAll(
                        hoursLabel,
                        grid
                );

        //--------------------------------
        // Sleep / Wake
        //--------------------------------
        VBox rhythmCard = new VBox(14);

        rhythmCard.setPadding(cardPadding);

        rhythmCard.setStyle(cardStyle);

        Label rhythmLabel =
                sectionTitle(
                        "Sleep & Wake Time"
                );

        HBox timeRow = new HBox(20);

        timeRow.setAlignment(Pos.CENTER);

        VBox wakeBox = new VBox(8);

        Label wakeLabel =
                new Label("☀ Wake Time");

        wakeLabel.setTextFill(Color.WHITE);

        Spinner<String> wakeSpinner =
                createTimeSpinner(
                        "06:30 AM",
                        "05:00 AM",
                        "06:00 AM",
                        "06:30 AM",
                        "07:00 AM",
                        "08:00 AM",
                        "09:00 AM"
                );

        wakeSpinner.valueProperty()
                .addListener(
                        (a,b,c) ->
                                controller
                                        .setWakeTime(c)
                );

        wakeBox.getChildren()
                .addAll(
                        wakeLabel,
                        wakeSpinner
                );

        VBox sleepBox = new VBox(8);

        Label sleepLabel =
                new Label("🌙 Sleep Time");

        sleepLabel.setTextFill(Color.WHITE);

        Spinner<String> sleepSpinner =
                createTimeSpinner(
                        "10:30 PM",
                        "09:00 PM",
                        "10:00 PM",
                        "10:30 PM",
                        "11:00 PM",
                        "12:00 AM",
                        "01:00 AM"
                );

        sleepSpinner.valueProperty()
                .addListener(
                        (a,b,c) ->
                                controller
                                        .setSleepTime(c)
                );

        sleepBox.getChildren()
                .addAll(
                        sleepLabel,
                        sleepSpinner
                );

        timeRow.getChildren()
                .addAll(
                        wakeBox,
                        sleepBox
                );

        rhythmCard.getChildren()
                .addAll(
                        rhythmLabel,
                        timeRow
                );

        //--------------------------------
        // Productive Time
        //--------------------------------
        VBox productCard = new VBox(12);

        productCard.setPadding(cardPadding);

        productCard.setStyle(cardStyle);

        Label productLabel =
                sectionTitle(
                        "Most Productive Time"
                );

        HBox prodRow = new HBox(12);

        prodRow.setAlignment(Pos.CENTER);

        ToggleGroup prodGroup =
                new ToggleGroup();

        String[] times = {
                "Morning",
                "Afternoon",
                "Evening",
                "Late Night"
        };

        for (String t : times) {

            ToggleButton btn =
                    new ToggleButton(t);

            btn.setToggleGroup(prodGroup);

            btn.setPrefSize(130, 42);

            btn.setStyle(
                    unselectedToggle()
            );

            btn.setOnAction(e -> {

                for (Toggle toggle :
                        prodGroup.getToggles()) {

                    ToggleButton b =
                            (ToggleButton) toggle;

                    b.setStyle(
                            unselectedToggle()
                    );
                }

                btn.setStyle(
                        selectedToggle()
                );

                controller
                        .setProductiveTime(t);
            });

            if (t.equals("Morning")) {

                btn.setSelected(true);

                btn.setStyle(
                        selectedToggle()
                );
            }

            prodRow.getChildren()
                    .add(btn);
        }

        productCard.getChildren()
                .addAll(
                        productLabel,
                        prodRow
                );

        //--------------------------------
        // Button
        //--------------------------------
        Button btn =
                new Button(
                        "Go To Dashboard"
                );

        btn.setPrefSize(260, 48);

        btn.setStyle(
                "-fx-background-color: " +
                        AppColors.PRIMARY + ";" +

                        "-fx-text-fill: white;" +

                        "-fx-font-size: 14;" +

                        "-fx-font-weight: bold;" +

                        "-fx-background-radius: 12;"
        );

        btn.setOnAction(e -> {

            AppData.setupData.printData();

            navigationController.goTo(
                    new DashboardView(
                            navigationController
                    ).getView()
            );
        });

        //--------------------------------
        // Footer
        //--------------------------------
        Label footer = new Label(
                "STEP 1 OF 3 — SETUP COMPLETE PROFILE"
        );

        footer.setTextFill(
                Color.web(
                        AppColors.SECONDARY_TEXT
                )
        );

        //--------------------------------
        // Add All
        //--------------------------------
        content.getChildren()
                .addAll(
                        header,
                        planCard,
                        daysCard,
                        hoursCard,
                        rhythmCard,
                        productCard,
                        btn,
                        footer
                );
    }

    //--------------------------------
    // Helpers
    //--------------------------------

    private Label sectionTitle(
            String text
    ) {

        Label l = new Label(text);

        l.setTextFill(Color.WHITE);

        l.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        18
                )
        );

        return l;
    }

    private String unselectedToggle() {

        return
                "-fx-background-color:#21262D;" +

                        "-fx-text-fill:white;" +

                        "-fx-background-radius:10;" +

                        "-fx-border-color:#2A2F3A;" +

                        "-fx-border-radius:10;";
    }

    private String selectedToggle() {

        return
                "-fx-background-color:#2F81F7;" +

                        "-fx-text-fill:white;" +

                        "-fx-background-radius:10;";
    }

    private Spinner<String> createTimeSpinner(
            String defaultValue,
            String... values
    ) {

        Spinner<String> sp =
                new Spinner<>();

        SpinnerValueFactory<String> f =

                new SpinnerValueFactory
                        .ListSpinnerValueFactory<>(

                        FXCollections
                                .observableArrayList(
                                        values
                                )
                );

        f.setValue(defaultValue);

        sp.setValueFactory(f);

        sp.setPrefWidth(140);

        return sp;
    }
}
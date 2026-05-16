package com.example.planova.views;

import com.example.planova.controllers.NavigationController;
import com.example.planova.controllers.PlansController;
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

import java.util.ArrayList;
import java.util.List;

public class NewPlanView {

    private BorderPane root;
    private VBox content;
    private VBox tasksContainer;
    private NavigationController nav;

    // Data
    private final List<Task> tempTasks = new ArrayList<>();
    private TextField planNameField;

    public NewPlanView(NavigationController nav) {
        this.nav = nav;
        createUI();
    }

    public Parent getView() {
        return root;
    }

    private void createUI() {
        root = new BorderPane();
        root.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        content = new VBox(25);
        content.setPadding(new Insets(35));
        content.setStyle("-fx-background-color: " + AppColors.BACKGROUND + ";");

        // ==================== HEADER ====================
        Label title = new Label("Create New Weekly Plan");
        title.setFont(Font.font("System", FontWeight.BOLD, 34));
        title.setTextFill(Color.WHITE);

        Label sub = new Label("Design your perfect week with focus and balance");
        sub.setTextFill(Color.web(AppColors.SECONDARY_TEXT));
        sub.setFont(Font.font(15));

        // Plan Name
        HBox planNameBox = createPlanNameSection();

        // Week Summary
        HBox weekInfo = createWeekInfoBox();

        // Tasks Section
        Label tasksTitle = new Label("Your Tasks");
        tasksTitle.setFont(Font.font("System", FontWeight.BOLD, 22));
        tasksTitle.setTextFill(Color.WHITE);

        tasksContainer = new VBox(10);

        // Add Task Form
        HBox addForm = createAddTaskForm();

        // Action Buttons
        HBox actionButtons = createActionButtons();

        content.getChildren().addAll(
                title,
                sub,
                planNameBox,
                weekInfo,
                tasksTitle,
                tasksContainer,
                addForm,
                actionButtons
        );

        ScrollPane scroll = new ScrollPane(content);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background: " + AppColors.BACKGROUND + "; -fx-background-color: " + AppColors.BACKGROUND + ";");

        root.setCenter(scroll);
    }

    private HBox createPlanNameSection() {
        HBox box = new HBox(15);
        box.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("Plan Name:");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("System", FontWeight.BOLD, 16));

        planNameField = new TextField("My Weekly Plan");
        planNameField.setPrefWidth(400);
        planNameField.setStyle(
                "-fx-background-color: " + AppColors.FIELD + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: #8B949E;" +
                        "-fx-background-radius: 12;"
        );

        box.getChildren().addAll(label, planNameField);
        return box;
    }

    private HBox createWeekInfoBox() {
        HBox box = new HBox(40);
        box.setPadding(new Insets(20));
        box.setStyle(
                "-fx-background-color: " + AppColors.CARD + ";" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 18;"
        );

        int totalFree = AppData.setupData.getFreeHoursPerDay().values().stream()
                .mapToInt(Integer::intValue).sum();

        Label hoursLabel = new Label("Total Free Hours This Week: " + totalFree + " hours");
        hoursLabel.setTextFill(Color.WHITE);
        hoursLabel.setFont(Font.font(16));

        box.getChildren().add(hoursLabel);
        return box;
    }

    private HBox createAddTaskForm() {
        HBox form = new HBox(15);
        form.setAlignment(Pos.CENTER_LEFT);
        form.setPadding(new Insets(10));
        form.setStyle("-fx-background-color: " + AppColors.CARD + "; -fx-background-radius: 16;");

        TextField taskName = new TextField();
        taskName.setPromptText("What do you want to accomplish?");
        taskName.setPrefWidth(320);
        styleField(taskName);

        ComboBox<String> category = new ComboBox<>();
        category.getItems().addAll("Deep Work", "Study", "Gym", "Project", "Reading", "Meeting", "Other");
        category.setValue("Deep Work");
        category.setPrefWidth(160);

        Spinner<Integer> duration = new Spinner<>(15, 300, 60, 15);
        duration.setPrefWidth(110);
        duration.setEditable(true);

        Button addBtn = new Button("Add Task");
        addBtn.setStyle("-fx-background-color: " + AppColors.PRIMARY + "; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 12;");
        addBtn.setPrefHeight(42);

        addBtn.setOnAction(e -> {
            if (!taskName.getText().trim().isEmpty()) {
                addTaskToUI(taskName.getText().trim(), duration.getValue(), category.getValue());
                taskName.clear();
            }
        });

        form.getChildren().addAll(taskName, category, new Label("Duration (min)"), duration, addBtn);
        return form;
    }

    private void addTaskToUI(String title, int durationMin, String category) {
        Task task = new Task(title, durationMin, category, "Flexible");
        tempTasks.add(task);

        HBox taskRow = new HBox(15);
        taskRow.setPadding(new Insets(14));
        taskRow.setAlignment(Pos.CENTER_LEFT);
        taskRow.setStyle(
                "-fx-background-color: #1F2630;" +
                        "-fx-background-radius: 14;" +
                        "-fx-border-color: #2A2F3A;" +
                        "-fx-border-radius: 14;"
        );

        Label nameLabel = new Label(title);
        nameLabel.setTextFill(Color.WHITE);
        nameLabel.setFont(Font.font(15));
        HBox.setHgrow(nameLabel, Priority.ALWAYS);

        Label catLabel = new Label(category);
        catLabel.setTextFill(Color.web(AppColors.PRIMARY));
        catLabel.setStyle("-fx-background-color: #2A2F3A; -fx-padding: 4 10; -fx-background-radius: 20;");

        Label durLabel = new Label(durationMin + " min");
        durLabel.setTextFill(Color.web(AppColors.SECONDARY_TEXT));

        Button deleteBtn = new Button("🗑");
        deleteBtn.setStyle("-fx-text-fill: #FF6B6B; -fx-background-color: transparent; -fx-font-size: 16;");

        deleteBtn.setOnAction(e -> {
            tempTasks.remove(task);
            tasksContainer.getChildren().remove(taskRow);
        });

        taskRow.getChildren().addAll(nameLabel, catLabel, durLabel, deleteBtn);
        tasksContainer.getChildren().add(taskRow);
    }

    private HBox createActionButtons() {
        HBox box = new HBox(15);
        box.setAlignment(Pos.CENTER_RIGHT);

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #8B949E; -fx-border-color: #8B949E; -fx-border-radius: 12;");
        cancelBtn.setPrefHeight(48);
        cancelBtn.setOnAction(e -> nav.goTo(new PlansController(nav).getView()));

        Button saveBtn = new Button("Save Plan");
        saveBtn.setStyle("-fx-background-color: " + AppColors.PRIMARY + "; -fx-text-fill: white; -fx-font-size: 16; -fx-font-weight: bold; -fx-background-radius: 12;");
        saveBtn.setPrefHeight(48);
        saveBtn.setPrefWidth(180);

        saveBtn.setOnAction(e -> savePlan());

        box.getChildren().addAll(cancelBtn, saveBtn);
        return box;
    }

    private void savePlan() {
        if (tempTasks.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please add at least one task to your plan.");
            alert.show();
            return;
        }

        String planName = planNameField.getText().trim();
        if (planName.isEmpty()) planName = "My Weekly Plan";

        WeeklyPlan plan = new WeeklyPlan(planName);
        for (Task task : tempTasks) {
            plan.addTask(task);
        }

        PlansController.savePlan(plan);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Your plan '" + planName + "' has been saved successfully!");
        alert.showAndWait();

        nav.goTo(new PlansController(nav).getView());
    }

    private void styleField(TextField field) {
        field.setStyle(
                "-fx-background-color: " + AppColors.FIELD + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: #8B949E;" +
                        "-fx-background-radius: 12;"
        );
    }
}
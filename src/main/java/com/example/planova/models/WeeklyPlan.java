package com.example.planova.models;

import java.util.ArrayList;
import java.util.List;

public class WeeklyPlan {
    private String planName;
    private List<Task> tasks = new ArrayList<>();

    public WeeklyPlan(String planName) {
        this.planName = planName;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getPlanName() {
        return planName;
    }
}
//package com.example.planova.models;
//
//public class Task {
//
//    private String title;
//    private int durationMinutes;   // مدة المهمة بالدقائق
//    private String category;       // Study, Gym, Work, etc.
//    private String day;            // Mon, Tue, ...
//
//    public Task(String title, int durationMinutes, String category, String day) {
//        this.title = title;
//        this.durationMinutes = durationMinutes;
//        this.category = category;
//        this.day = day;
//    }
//
//    // Getters & Setters
//    public String getTitle() { return title; }
//    public void setTitle(String title) { this.title = title; }
//
//    public int getDurationMinutes() { return durationMinutes; }
//    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
//
//    public String getCategory() { return category; }
//    public void setCategory(String category) { this.category = category; }
//
//    public String getDay() { return day; }
//    public void setDay(String day) { this.day = day; }
//
//    public String getDurationFormatted() {
//        int hours = durationMinutes / 60;
//        int mins = durationMinutes % 60;
//        return hours > 0 ? hours + "h " + mins + "m" : mins + "m";
//    }
//}

package com.example.planova.models;

public class Task {

    private String title;
    private int durationMinutes;   // مدة المهمة بالدقائق
    private String category;       // Study, Gym, Work, etc.
    private String day;            // Mon, Tue, ...
    private String description;    // وصف المهمة

    // Constructor without description
    public Task(String title, int durationMinutes, String category, String day) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.category = category;
        this.day = day;
        this.description = "";   // default empty
    }

    // Constructor with description
    public Task(String title, int durationMinutes, String category, String day, String description) {
        this(title, durationMinutes, category, day);
        this.description = description;
    }

    // Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDurationFormatted() {
        int hours = durationMinutes / 60;
        int mins = durationMinutes % 60;
        return hours > 0 ? hours + "h " + mins + "m" : mins + "m";
    }
}
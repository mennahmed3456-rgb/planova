package com.example.planova.models;

import java.util.ArrayList;
import java.util.HashMap;

public class SetupData {

    //--------------------------------
    // Plan Type
    //--------------------------------

    private String planType;

    //--------------------------------
    // Available Days
    //--------------------------------

    private ArrayList<String> availableDays =
            new ArrayList<>();

    //--------------------------------
    // Free Hours Per Day
    //--------------------------------

    private HashMap<String, Integer>
            freeHoursPerDay =
            new HashMap<>();

    //--------------------------------
    // Sleep & Wake
    //--------------------------------

    private String wakeTime;

    private String sleepTime;

    //--------------------------------
    // Productive Time
    //--------------------------------

    private String productiveTime;

    //--------------------------------
    // Constructor
    //--------------------------------

    public SetupData() {

        //--------------------------------
        // Default Free Hours
        //--------------------------------

        freeHoursPerDay.put("Mon", 4);
        freeHoursPerDay.put("Tue", 4);
        freeHoursPerDay.put("Wed", 4);
        freeHoursPerDay.put("Thu", 4);
        freeHoursPerDay.put("Fri", 4);
        freeHoursPerDay.put("Sat", 4);
        freeHoursPerDay.put("Sun", 4);

        //--------------------------------
        // Default Days
        //--------------------------------

        availableDays.add("Mon");
        availableDays.add("Tue");
        availableDays.add("Wed");
        availableDays.add("Thu");
        availableDays.add("Fri");

        //--------------------------------
        // Default Values
        //--------------------------------

        planType = "Balanced";

        wakeTime = "06:30 AM";

        sleepTime = "10:30 PM";

        productiveTime = "Morning";
    }

    //--------------------------------
    // Plan Type
    //--------------------------------

    public String getPlanType() {

        return planType;
    }

    public void setPlanType(String planType) {

        this.planType = planType;
    }

    //--------------------------------
    // Available Days
    //--------------------------------

    public ArrayList<String>
    getAvailableDays() {

        return availableDays;
    }

    public void setAvailableDays(
            ArrayList<String> availableDays
    ) {

        this.availableDays =
                availableDays;
    }

    //--------------------------------
    // Free Hours
    //--------------------------------

    public HashMap<String, Integer>
    getFreeHoursPerDay() {

        return freeHoursPerDay;
    }

    public void setFreeHoursPerDay(
            HashMap<String, Integer>
                    freeHoursPerDay
    ) {

        this.freeHoursPerDay =
                freeHoursPerDay;
    }

    //--------------------------------
    // Wake Time
    //--------------------------------

    public String getWakeTime() {

        return wakeTime;
    }

    public void setWakeTime(
            String wakeTime
    ) {

        this.wakeTime = wakeTime;
    }

    //--------------------------------
    // Sleep Time
    //--------------------------------

    public String getSleepTime() {

        return sleepTime;
    }

    public void setSleepTime(
            String sleepTime
    ) {

        this.sleepTime = sleepTime;
    }

    //--------------------------------
    // Productive Time
    //--------------------------------

    public String getProductiveTime() {

        return productiveTime;
    }

    public void setProductiveTime(
            String productiveTime
    ) {

        this.productiveTime =
                productiveTime;
    }

    //--------------------------------
    // Debug Print
    //--------------------------------

    public void printData() {

        System.out.println(
                "========== SETUP DATA =========="
        );

        System.out.println(
                "Plan Type: " + planType
        );

        System.out.println(
                "Wake Time: " + wakeTime
        );

        System.out.println(
                "Sleep Time: " + sleepTime
        );

        System.out.println(
                "Productive Time: " +
                        productiveTime
        );

        System.out.println(
                "Available Days:"
        );

        for(String day : availableDays) {

            System.out.println(day);
        }

        System.out.println(
                "Free Hours Per Day:"
        );

        for(String day :
                freeHoursPerDay.keySet()) {

            System.out.println(

                    day + " -> " +

                            freeHoursPerDay.get(day)
            );
        }

        System.out.println(
                "================================"
        );
    }
}
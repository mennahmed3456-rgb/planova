package com.example.planova.controllers;

import com.example.planova.data.AppData;

public class SetupController {

    //--------------------------------
    // Plan Type
    //--------------------------------

    public void setPlanType(String planType) {

        AppData.setupData.setPlanType(planType);
    }

    //--------------------------------
    // Free Hours
    //--------------------------------

    public void setFreeHours(
            String day,
            int hours
    ) {

        AppData.setupData
                .getFreeHoursPerDay()
                .put(day, hours);
    }

    //--------------------------------
    // Wake Time
    //--------------------------------

    public void setWakeTime(String time) {

        AppData.setupData.setWakeTime(time);
    }

    //--------------------------------
    // Sleep Time
    //--------------------------------

    public void setSleepTime(String time) {

        AppData.setupData.setSleepTime(time);
    }

    //--------------------------------
    // Productive Time
    //--------------------------------

    public void setProductiveTime(String time) {

        AppData.setupData
                .setProductiveTime(time);
    }
}
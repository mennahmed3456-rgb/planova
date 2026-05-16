package com.example.planova.controllers;

import com.example.planova.data.AppData;
import com.example.planova.models.User;

public class RegisterController {

    public boolean register(
            String name,
            String email,
            String password
    ) {

        if(name.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty()) {

            return false;
        }

        User user = new User(
                name,
                email,
                password
        );

        AppData.users.add(user);

        System.out.println("User Added!");

        return true;
    }
}
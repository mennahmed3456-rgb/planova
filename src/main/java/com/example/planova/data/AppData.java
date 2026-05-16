//package com.example.planova.data;
//
//import com.example.planova.models.SetupData;
//import com.example.planova.models.User;
//
//import java.util.ArrayList;
//
//public class AppData {
//
//    //--------------------------------
//    // Users
//    //--------------------------------
//
//    public static ArrayList<User> users =
//            new ArrayList<>();
//
//    //--------------------------------
//    // Temporary Setup Data
//    //--------------------------------
//
//    public static SetupData setupData =
//            new SetupData();
//
//    //--------------------------------
//    // Dummy Users
//    //--------------------------------
//
//    static {
//
//        users.add(
//
//                new User(
//
//                        "Menna Ahmed",
//
//                        "m",
//
//                        "1234"
//                )
//        );
//
//        users.add(
//
//                new User(
//
//                        "Admin",
//
//                        "admin@gmail.com",
//
//                        "admin123"
//                )
//        );
//    }
//}

package com.example.planova.data;

import com.example.planova.models.SetupData;
import com.example.planova.models.User;
import com.example.planova.models.WeeklyPlan;

import java.util.ArrayList;

public class AppData {

    //--------------------------------
    // Users
    //--------------------------------

    public static ArrayList<User> users =
            new ArrayList<>();

    //--------------------------------
    // Temporary Setup Data
    //--------------------------------

    public static SetupData setupData =
            new SetupData();

    //--------------------------------
    // Weekly Plans Management
    //--------------------------------

    /**
     * List of all saved weekly plans
     */
    public static ArrayList<WeeklyPlan> weeklyPlans =
            new ArrayList<>();

    /**
     * The currently active/being edited plan
     */
    public static WeeklyPlan currentPlan = null;

    //--------------------------------
    // Dummy Users (for testing)
    //--------------------------------

    static {

        users.add(
                new User(
                        "Menna Ahmed",
                        "m",
                        "1234"
                )
        );

        users.add(
                new User(
                        "Admin",
                        "admin@gmail.com",
                        "admin123"
                )
        );
    }
}
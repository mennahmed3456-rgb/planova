import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) {

        // Create Tasks using Factory Pattern
        List<Task> tasks = new ArrayList<>();

        tasks.add(
                TaskFactory.createTask(
                        "study",
                        "Solve Problems",
                        2
                )
        );

        tasks.add(
                TaskFactory.createTask(
                        "gym",
                        "Cardio Training",
                        1
                )
        );

        tasks.add(
                TaskFactory.createTask(
                        "work",
                        "Finish Project",
                        3
                )
        );


        // Strategy Pattern
        PlanStrategy strategy =
                new BalancedStrategy();

        strategy.generatePlan(tasks);
    }

import java.util.List;

public class DeepFocusStrategy implements PlanStrategy {

    @Override
    public void generatePlan(List<Task> tasks) {

        System.out.println("Deep Focus Plan:");

        for (Task task : tasks) {

            System.out.println(
                    "High Focus -> " +
                            task.getTitle()
            );
        }
    }
}
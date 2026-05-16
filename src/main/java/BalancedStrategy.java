import java.util.List;

public class BalancedStrategy implements PlanStrategy {

    @Override
    public void generatePlan(List<Task> tasks) {

        System.out.println("Balanced Plan:");

        for (Task task : tasks) {

            System.out.println(
                    task.getTaskType() +
                            " - " +
                            task.getTitle()
            );
        }
    }
}
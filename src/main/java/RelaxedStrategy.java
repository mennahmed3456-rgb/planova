import java.util.List;

public class RelaxedStrategy implements PlanStrategy {

    @Override
    public void generatePlan(List<Task> tasks) {

        System.out.println("Relaxed Plan:");

        for (Task task : tasks) {

            System.out.println(
                    task.getTitle() +
                            " with extra breaks"
            );
        }
    }
}
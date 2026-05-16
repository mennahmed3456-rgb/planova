public class TaskUI implements PlanObserver {

    @Override
    public void update(String message) {

        System.out.println(
                "UI Notification: " + message
        );
    }
}
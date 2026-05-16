import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface PlanObserver {

    void update(String message);
}

// Subject Class
class PlanManager {

    private List<PlanObserver> observers =
            new ArrayList<>();

    public void addObserver(
            PlanObserver observer
    ) {

        observers.add(observer);
    }

    public void notifyObservers(
            String message
    ) {

        for (PlanObserver observer : observers) {

            observer.update(message);
        }
    }

    public void generateNewPlan() {

        System.out.println(
                "Generating Plan..."
        );

        notifyObservers(
                "Plan Updated Successfully!"
        );
    }
}

// Observer Class
class TaskUI
        implements PlanObserver {

    @Override
    public void update(String message) {

        System.out.println(
                "UI Notification: "
                        + message
        );
    }
}

// Main Class
public class DemoObserver {

    public static void main(String[] args) {

        PlanManager manager =
                new PlanManager();

        TaskUI ui =
                new TaskUI();

        manager.addObserver(ui);

        manager.generateNewPlan();
    }
}
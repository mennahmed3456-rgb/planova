import java.util.List;
import java.util.ArrayList;

public class PlanManager {

    private List<PlanObserver> observers =
            new ArrayList<>();

    public void addObserver(PlanObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {

        for (PlanObserver observer : observers) {
            observer.update(message);
        }
    }

    public void generateNewPlan() {

        System.out.println("Generating Plan...");

        notifyObservers(
                "Plan Updated Successfully!"
        );
    }
}
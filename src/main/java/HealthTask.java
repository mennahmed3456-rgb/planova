public class HealthTask extends Task {

    public HealthTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Health";
    }
}
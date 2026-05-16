public class WorkTask extends Task {

    public WorkTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Work";
    }
}
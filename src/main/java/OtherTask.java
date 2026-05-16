public class OtherTask extends Task {

    public OtherTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Other";
    }
}
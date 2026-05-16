public class ReadingTask extends Task {

    public ReadingTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Reading";
    }
}
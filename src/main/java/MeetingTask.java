public class MeetingTask extends Task {

    public MeetingTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Meeting";
    }
}
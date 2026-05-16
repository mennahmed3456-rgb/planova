public class StudyTask extends Task {

    public StudyTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Study";
    }
}
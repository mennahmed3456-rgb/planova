public class PersonalTask extends Task {

    public PersonalTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Personal";
    }
}
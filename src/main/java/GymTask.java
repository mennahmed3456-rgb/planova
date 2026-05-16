public class GymTask extends Task {

    public GymTask(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getTaskType() {
        return "Gym";
    }
}
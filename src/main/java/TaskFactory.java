public class TaskFactory {

    public static Task createTask(String type, String title, int duration) {

        switch (type.toLowerCase()) {

            case "study":
                return new StudyTask(title, duration);

            case "work":
                return new WorkTask(title, duration);

            case "gym":
                return new GymTask(title, duration);

            case "health":
                return new HealthTask(title, duration);

            case "reading":
                return new ReadingTask(title, duration);

            case "personal":
                return new PersonalTask(title, duration);

            case "meeting":
                return new MeetingTask(title, duration);

            default:
                return new OtherTask(title, duration);
        }
    }
}
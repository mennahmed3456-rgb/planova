// Task Class
class Task {

    private String type;
    private String title;

    public Task(
            String type,
            String title
    ) {

        this.type = type;
        this.title = title;
    }

    public String getType() {

        return type;
    }

    public String getTitle() {

        return title;
    }
}

// Adapter Class
class GPTAdapter {

    public Task convertToTask(
            String text
    ) {

        String[] parts =
                text.split(":");

        String type =
                parts[0].trim();

        String title =
                parts[1].trim();

        return new Task(
                type,
                title
        );
    }
}

// Main Class
public class DemoAdapter {

    public static void main(String[] args) {

        GPTAdapter adapter =
                new GPTAdapter();

        Task task =
                adapter.convertToTask(
                        "study: Learn JavaFX"
                );

        System.out.println(
                "Task Type: "
                        + task.getType()
        );

        System.out.println(
                "Task Title: "
                        + task.getTitle()
        );
    }
}
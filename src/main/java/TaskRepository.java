import java.util.List;

public interface TaskRepository {

    void addTask(Task task);

    List<Task> getAllTasks();
}   
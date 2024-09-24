import java.util.ArrayList;

class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

public class TaskManagementSystem {
    private ArrayList<Task> tasks;

    public TaskManagementSystem() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void updateTask(int index, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setDescription(newDescription);
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i).getDescription());
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem taskManager = new TaskManagementSystem();
        taskManager.addTask("Complete homework");
        taskManager.addTask("Read a book");
        taskManager.displayTasks();
        taskManager.updateTask(1, "Read a science fiction book");
        taskManager.displayTasks();
        taskManager.removeTask(0);
        taskManager.displayTasks();
    }
}

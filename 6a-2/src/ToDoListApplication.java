import java.util.ArrayList;
import java.util.List;

public class ToDoListApplication {
    private List<String> tasks;

    public ToDoListApplication() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        ToDoListApplication toDoList = new ToDoListApplication();
        toDoList.addTask("Go shopping");
        toDoList.addTask("Finish project");
        toDoList.displayTasks();
        toDoList.updateTask(0, "Go shopping at the mall");
        toDoList.displayTasks();
        toDoList.removeTask(1);
        toDoList.displayTasks();
    }
}
import java.util.*;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Task {
    private String name;
    private boolean isCompleted;
    private Priority priority;
    private String category;

    public Task(String name, Priority priority, String category) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.isCompleted = false;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " [" + category + "] - Priority: " + priority + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name, Priority priority, String category) {
        tasks.add(new Task(name, priority, category));
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // MISSING FEATURES:

    // 1. Remove a task by name
    public void removeTask(String name) {
        // TODO: Implement removal logic
    }

    // 2. Find all completed tasks
    public List<Task> getCompletedTasks() {
        // TODO: Implement logic to return completed tasks
        return new ArrayList<>();
    }

    // 3. List tasks sorted by name
    public void sortTasksByName() {
        // TODO: Implement sorting logic
    }

    // 4. Sort tasks by priority
    public void sortTasksByPriority() {
        // TODO: Implement sorting by priority logic
    }

    // 5. Filter tasks by category
    public List<Task> filterByCategory(String category) {
        // TODO: Implement filtering logic
        return new ArrayList<>();
    }

    // 6. Find the highest-priority unfinished task
    public List<Task> getMostUrgentTasks() {
        // TODO: Implement logic to find most urgent tasks
        List<Task> urgentTasks = new ArrayList<>();
        Priority highestPriority = null;
        for(Task task : tasks) {
            if (!task.isCompleted()) {
                if (highestPriority == null || task.getPriority().ordinal() > highestPriority.ordinal()) {
                    highestPriority = task.getPriority();
                }
            }
        }

        if (highestPriority != null) {
            for (Task task : tasks) {
                if (!task.isCompleted() && task.getPriority() == highestPriority) {
                    urgentTasks.add(task);
                }
            }
        }
        return urgentTasks;
    }

    // 7. Count tasks per category
    public Map<String, Integer> countTasksPerCategory() {
        // TODO: Implement counting logic
        Map<String, Integer> categoryCount = new HashMap<>();
        for (Task task : tasks) {
            String category = task.getCategory();

            if (categoryCount.containsKey(category)) {
                int currentCount = categoryCount.get(category);
                categoryCount.put(category, currentCount + 1);
            } else {
                categoryCount.put(category, 1);
            }
        }
        return categoryCount;
    }

    // 8. Mark a task as completed by name
    public void markTaskCompleted(String name) {
        // TODO: Implement completion logic
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.complete();
                System.out.println(task + " marked as completed");
                return;
            }
        }
        System.out.println("Task doesn't exist");
    }

    // 9. Mark all tasks in a category as completed
    public void markCategoryCompleted(String category) {
        // TODO: Implement bulk completion logic
    }
}

public class SI2025Lab1Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask("Write report", Priority.HIGH, "Work");
        manager.addTask("Submit assignment", Priority.MEDIUM, "School");
        manager.addTask("Buy groceries", Priority.LOW, "Personal");

        // MISSING: Calls to the new methods that will be implemented
        for(Task task : manager.getMostUrgentTasks()) {
            System.out.println(task);
        }
        System.out.println("Task count per category: " + manager.countTasksPerCategory());
        manager.markTaskCompleted("Buy groceries");

        manager.printTasks();
    }
}
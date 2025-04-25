package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages tasks by adding, updating, retrieving, and printing them grouped by status.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the task manager.
     * 
     * @param name the name of the task (must be unique)
     * @param priority the priority of the task
     * @param status the initial status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * 
     * @param name the name of the task
     * @return the Task object
     * @throws TaskNotFoundException if the task is not found
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name the name of the task
     * @param newStatus the new status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws TaskNotFoundException if the task is not found
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new LinkedHashMap<>();
        grouped.put("TODO", new ArrayList<>());
        grouped.put("IN_PROGRESS", new ArrayList<>());
        grouped.put("DONE", new ArrayList<>());

        for (Task task : tasks.values()) {
            grouped.get(task.getStatus()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (String status : grouped.keySet()) {
            System.out.println(status + ":");
            for (Task task : grouped.get(status)) {
                System.out.println("  " + task);
            }
        }
    }
}

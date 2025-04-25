package org.howard.edu.lspfinal.question2;

/**
 * Represents a single task in the TaskManager system.
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a Task object.
     * 
     * @param name the name of the task
     * @param priority the priority of the task (lower number = higher priority)
     * @param status the status of the task ("TODO", "IN_PROGRESS", or "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns the name of the task.
     * @return task name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the task's current status.
     * @return task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the task's status.
     * @param newStatus new status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    /**
     * Returns a string representation of the task.
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}

// package edu.ucalgary.oop;

import java.util.Objects;

public class Task {
    private int id;
    private String title;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String title, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Deep copy method
    public Task copy() {
        return new Task(this.id, this.title, this.isCompleted);
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id &&
                isCompleted == task.isCompleted &&
                Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }

    // Main method for testing
    public static void main(String[] args) {
        Task task1 = new Task(1, "Task 1", false);
        Task task2 = task1.copy();

        System.out.println("Task 1: " + task1.getTitle() + ", Completed: " + task1.isCompleted());
        System.out.println("Task 2: " + task2.getTitle() + ", Completed: " + task2.isCompleted());

        // Modify task1 and check if task2 is unaffected
        task1.setCompleted(true);
        System.out.println("Task 1: " + task1.getTitle() + ", Completed: " + task1.isCompleted());
        System.out.println("Task 2: " + task2.getTitle() + ", Completed: " + task2.isCompleted());
    }
}

package edu.ucalgary.oop;

public class Task {
    private String id;
    private String title;
    private boolean isCompleted;

    public Task(String id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    // Copy constructor for deep copying task objects
    public Task(Task originalTask) {
        this.id = originalTask.id;
        this.title = originalTask.title;
        this.isCompleted = originalTask.isCompleted;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    // Deep copy method for Task objects
    public Task copy() {
        return new Task(this);
    }
}

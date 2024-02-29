package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        tasks = new ArrayList<>();
        history = new Stack<>();
    }

    @Override
    public void addTask(Task task) {
        saveState();
        tasks.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                return;
            }
        }
    }

    @Override
    public void deleteTask(String taskId) {
        saveState();
        tasks.removeIf(task -> task.getId().equals(taskId));
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean isCompleted) {
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setTitle(newTitle);
                task.setCompleted(isCompleted);
                return;
            }
        }
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = new ArrayList<>(history.pop());
        }
    }

    @Override
    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    // Private method to save current state into history stack
    private void saveState() {
        history.push(new ArrayList<>(tasks));
    }
}

package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> historyStack;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.historyStack = new Stack<>();
    }

    @Override
    public void addTask(Task task) {
        saveState();
        tasks.add(task.copy());
    }

    @Override
    public void completeTask(String taskId) {
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                break;
            }
        }
    }

    @Override
    public void deleteTask(String taskId) {
        saveState();
        tasks.removeIf(task -> task.getId().equals(taskId));
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean newCompletionStatus) {
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setTitle(newTitle);
                task.setCompleted(newCompletionStatus);
                break;
            }
        }
    }

    @Override
    public void undo() {
        if (!historyStack.isEmpty()) {
            tasks = historyStack.pop();
        }
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }

    private void saveState() {
        List<Task> currentState = new ArrayList<>();
        for (Task task : tasks) {
            currentState.add(task.copy());
        }
        historyStack.push(currentState);
    }
}

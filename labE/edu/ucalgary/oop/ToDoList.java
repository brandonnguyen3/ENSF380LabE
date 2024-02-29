package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.history = new Stack<>();
    }

    @Override
    public void addTask(Task task) {
        history.push(copyTasks(tasks));
        tasks.add(new Task(task));
    }

    @Override
    public void completeTask(String id) {
        history.push(copyTasks(tasks));
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setCompleted(true);
                break;
            }
        }
    }

// need edit, delete and undo

    @Override
    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    private List<Task> copyTasks(List<Task> tasks) {
        List<Task> copy = new ArrayList<>();
        for (Task task : tasks) {
            copy.add(new Task(task));
        }
        return copy;
    }
}
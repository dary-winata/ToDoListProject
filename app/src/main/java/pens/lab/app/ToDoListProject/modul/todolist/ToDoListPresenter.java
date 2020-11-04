package pens.lab.app.belajaractivity.modul.todolist;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.model.Task;

public class ToDoListPresenter implements ToDoListContract.Presenter{
    private final ToDoListContract.View view;

    public ToDoListPresenter(ToDoListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performDetailTask(int id) {
        view.goToDetail(id);
    }

    @Override
    public void performAddTask() {
        view.goToAddList();
    }

    @Override
    public void performLogut() {
        view.goToLogin();
    }

    @Override
    public ArrayList<Task> getValueData() {
        ArrayList<Task> data = new ArrayList<>();
        data.add(new Task(1,"Task 1", "Kerjakan task satu"));
        data.add(new Task(2, "Task 2", "Kerjakan task dua"));

        return data;
    }
}

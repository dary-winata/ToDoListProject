package pens.lab.app.belajaractivity.modul.AddTask;

import pens.lab.app.belajaractivity.modul.AddTask.AddTaskConctract;

public class AddTaskPresenter implements AddTaskConctract.Presenter {
    private final AddTaskConctract.View view;

    public AddTaskPresenter(AddTaskConctract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void performToDoList() {
        view.goToDoList();
    }
}

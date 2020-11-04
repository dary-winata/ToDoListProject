package pens.lab.app.belajaractivity.modul.DetailTask;

import pens.lab.app.belajaractivity.modul.DetailTask.DetailTaskContract;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListContract;

public class DetailTaskPresenter implements DetailTaskContract.Presenter {
    private final DetailTaskContract.View view;

    public DetailTaskPresenter(DetailTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void performCancelToDoList() {
        view.redirectToDoList();
    }

    @Override
    public void performEditToDoList() {
        view.redirectToDoList();
    }
}

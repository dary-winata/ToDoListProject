package pens.lab.app.belajaractivity.modul.todolist;

public class ToDoListPresenter implements ToDoListContract.Presenter{
    private final ToDoListContract.View view;

    public ToDoListPresenter(ToDoListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performDetailTask() {
        view.goToDetail();
    }

    @Override
    public void performAddTask() {
        view.goToAddList();
    }
}

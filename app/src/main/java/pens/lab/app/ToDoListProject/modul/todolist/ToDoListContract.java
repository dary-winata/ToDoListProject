package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;
import pens.lab.app.belajaractivity.model.Task;

public interface ToDoListContract {
    interface View extends BaseView<Presenter> {
        void goToDetail(int id);
        void goToAddList();
        void goToLogin();
    }

    interface Presenter extends BasePresenter {
        void performDetailTask(int id);
        void performAddTask();
        void performLogut();
        ArrayList<Task> getValueData();
    }
}

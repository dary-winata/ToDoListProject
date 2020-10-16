package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

public interface ToDoListContract {
    interface View extends BaseView<Presenter> {
        void goToDetail();
        void goToAddList();
    }

    interface Presenter extends BasePresenter {
//        String[] getValueIntent(Intent intent);
        void performDetailTask();
        void performAddTask();
    }
}

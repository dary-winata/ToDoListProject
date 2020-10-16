package pens.lab.app.belajaractivity.modul.AddTask;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

public interface AddTaskConctract {
    interface View extends BaseView<Presenter> {
        void goToDoList();
    }

    interface Presenter extends BasePresenter {
        void performToDoList();
    }
}

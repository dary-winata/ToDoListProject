package pens.lab.app.belajaractivity.modul.DetailTask;

import android.content.Intent;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;
import pens.lab.app.belajaractivity.modul.profile.ProfileContract;

public interface DetailTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToDoList();
    }

    interface Presenter extends BasePresenter {
//        String[] getValueIntent(Intent intent);
        void performCancelToDoList();
        void performEditToDoList();
    }
}

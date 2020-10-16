package pens.lab.app.belajaractivity.modul.profile;

import android.content.Intent;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface ProfileContract {
    interface View extends BaseView<Presenter> {
        void goToLogin();
    }

    interface Presenter extends BasePresenter {
        String[] getValueIntent(Intent intent);
    }
}

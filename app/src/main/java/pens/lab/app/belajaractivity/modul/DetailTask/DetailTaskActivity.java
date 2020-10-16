package pens.lab.app.belajaractivity.modul.DetailTask;

import android.view.View;

import pens.lab.app.belajaractivity.base.BaseFragmentHolderActivity;
import pens.lab.app.belajaractivity.modul.DetailTask.DetailTaskFragment;

public class DetailTaskActivity  extends BaseFragmentHolderActivity {
    DetailTaskFragment detailTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        detailTaskFragment = new DetailTaskFragment();
        setCurrentFragment(detailTaskFragment, false);
    }
}

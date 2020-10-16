package pens.lab.app.belajaractivity.modul.AddTask;

import android.view.View;

import pens.lab.app.belajaractivity.base.BaseFragmentHolderActivity;
import pens.lab.app.belajaractivity.modul.AddTask.AddTaskFragment;

public class AddTaskActivity extends BaseFragmentHolderActivity {
    AddTaskFragment addTaskFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        addTaskFragment = new AddTaskFragment();
        setCurrentFragment(addTaskFragment, false);
    }
}

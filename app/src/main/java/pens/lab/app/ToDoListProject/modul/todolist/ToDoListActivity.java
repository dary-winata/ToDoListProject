package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;
import android.view.View;

import pens.lab.app.belajaractivity.base.BaseFragmentHolderActivity;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListFragment;
import pens.lab.app.belajaractivity.modul.profile.ProfileFragment;

public class ToDoListActivity extends BaseFragmentHolderActivity{
    ToDoListFragment todolistFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.VISIBLE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        todolistFragment = new ToDoListFragment();
        setCurrentFragment(todolistFragment, false);
    }
}

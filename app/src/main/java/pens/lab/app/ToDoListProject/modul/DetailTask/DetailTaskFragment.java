package pens.lab.app.belajaractivity.modul.DetailTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.DetailTask.DetailTaskActivity;
import pens.lab.app.belajaractivity.modul.DetailTask.DetailTaskContract;
import pens.lab.app.belajaractivity.modul.DetailTask.DetailTaskPresenter;
import pens.lab.app.belajaractivity.modul.profile.ProfileContract;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListActivity;

public class DetailTaskFragment extends BaseFragment<DetailTaskActivity, DetailTaskContract.Presenter> implements DetailTaskContract.View {
    Button btnCancel;
    Button btnEdit;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_detail_task, container, false);
        mPresenter = new DetailTaskPresenter(this);
        mPresenter.start();

        btnCancel = fragmentView.findViewById(R.id.btnCancel);
        btnEdit = fragmentView.findViewById(R.id.btnEdit);

        setbtnEditonClick();
        setbtnCancelonClick();

        setTitle("My Profile");

        return fragmentView;
    }

    @Override
    public void setPresenter(DetailTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setBtnCancel(){
        mPresenter.performCancelToDoList();
    }

    public void setBtnAdd(){
        mPresenter.performEditToDoList();
    }

    public void setbtnEditonClick(){
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnAdd();
            }
        });
    }

    public void setbtnCancelonClick(){
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnCancel();
            }
        });
    }

    @Override
    public void redirectToDoList() {
        intent = new Intent(activity, ToDoListActivity.class);
        startActivity(intent);
        activity.finish();
    }
}

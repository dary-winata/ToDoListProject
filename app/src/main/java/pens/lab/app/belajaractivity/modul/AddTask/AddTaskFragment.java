package pens.lab.app.belajaractivity.modul.AddTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager2.adapter.FragmentViewHolder;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.AddTask.AddTaskActivity;
import pens.lab.app.belajaractivity.modul.AddTask.AddTaskConctract;
import pens.lab.app.belajaractivity.modul.AddTask.AddTaskPresenter;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListActivity;

public class AddTaskFragment extends BaseFragment<AddTaskActivity, AddTaskConctract.Presenter> implements AddTaskConctract.View{
    Button btnAdd;

    public AddTaskFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add_task, container, false);
        mPresenter = new AddTaskPresenter(this);
        mPresenter.start();

        btnAdd = fragmentView.findViewById(R.id.btnAddTask);
        setBtnAddClick();


        setTitle("My Profile");

        return fragmentView;
    }

    public void setTextViewDetailTask(){
        mPresenter.performToDoList();
    }

    @Override
    public void setPresenter(AddTaskConctract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setBtnAddClick(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextViewDetailTask();
            }
        });
    }

    @Override
    public void goToDoList() {
        Intent intent = new Intent(activity, ToDoListActivity.class);
        startActivity(intent);
        activity.finish();
    }
}

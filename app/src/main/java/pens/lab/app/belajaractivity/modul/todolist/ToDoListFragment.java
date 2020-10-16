package pens.lab.app.belajaractivity.modul.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.AddTask.AddTaskActivity;
import pens.lab.app.belajaractivity.modul.DetailTask.DetailTaskActivity;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListContract;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListPresenter;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListActivity;

public class ToDoListFragment extends BaseFragment<ToDoListActivity, ToDoListContract.Presenter> implements ToDoListContract.View {
    TextView todoList;
    FloatingActionButton addBtn;

    public ToDoListFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_todo_list, container, false);
        mPresenter = new ToDoListPresenter(this);
        mPresenter.start();

        todoList = fragmentView.findViewById(R.id.todolistText);
        addBtn = fragmentView.findViewById(R.id.floatingActionButtonAddTask);
        setTextViewClick();
        setAddBtn();


        setTitle("My Profile");

        return fragmentView;
    }

    public void setTextViewDetailTask(){
        mPresenter.performDetailTask();
    }

    public void setAddBtnViewDetailTask(){mPresenter.performAddTask();}

    @Override
    public void setPresenter(ToDoListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setTextViewClick(){
        todoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextViewDetailTask();
            }
        });
    }

    public void setAddBtn(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAddBtnViewDetailTask();
            }
        });
    }

    @Override
    public void goToDetail() {
        Intent intent = new Intent(activity, DetailTaskActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void goToAddList() {
        Intent intent = new Intent(activity, AddTaskActivity.class);
        startActivity(intent);
        activity.finish();
    }
}

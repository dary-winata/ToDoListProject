package pens.lab.app.belajaractivity.modul.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.model.Task;
import pens.lab.app.belajaractivity.modul.AddTask.AddTaskActivity;
import pens.lab.app.belajaractivity.modul.DetailTask.DetailTaskActivity;
import pens.lab.app.belajaractivity.modul.login.LoginActivity;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListContract;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListPresenter;
import pens.lab.app.belajaractivity.modul.todolist.ToDoListActivity;
import pens.lab.app.belajaractivity.utils.RecyclerViewAdapterTodolist;

public class ToDoListFragment extends BaseFragment<ToDoListActivity, ToDoListContract.Presenter> implements ToDoListContract.View {
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    TextView todoList;
    FloatingActionButton addBtn;
    ImageButton backBtn;

    public ToDoListFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_todo_list, container, false);
        mPresenter = new ToDoListPresenter(this);
        mPresenter.start();

        addBtn = fragmentView.findViewById(R.id.floatingActionButtonAddTask);
        setBackBtn();
        setAddBtn();

        mRecyclerView = fragmentView.findViewById(R.id.recyclerToDoListView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        final ArrayList<Task> data = mPresenter.getValueData();
        mAdapter = new RecyclerViewAdapterTodolist(data);
        mRecyclerView.setAdapter(mAdapter);

        setTitle("My Profile");

        setTextViewClick(data);

        return fragmentView;
    }

    public void setBackBtn(){
        .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLogoutBtnView();
            }
        });
    }

    public void setTextViewDetailTask(int id){
        mPresenter.performDetailTask(id);
    }

    public void setLogoutBtnView(){mPresenter.performLogut();}

    public void setAddBtnView(){mPresenter.performAddTask();}

    @Override
    public void setPresenter(ToDoListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setTextViewClick(final ArrayList<Task> data){
        ((RecyclerViewAdapterTodolist) mAdapter).setOnItemClickListener(new RecyclerViewAdapterTodolist.MyClickListener() {

            @Override
            public void onItemClick(int position, View v) {
                int id = data.get(position).getId();
                Log.d("BELAJAR ACTIVITY",">>>>>"+ position);
                setTextViewDetailTask(id);
            }
        });
    }

    public void setAddBtn(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAddBtnView();
            }
        });
    }

    @Override
    public void goToDetail(int id) {
        Intent intent = new Intent(activity, DetailTaskActivity.class);
        intent.putExtra("index", id);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void goToAddList() {
        Intent intent = new Intent(activity, AddTaskActivity.class);
        startActivity(intent);
        activity.finish();
    }

    public void goToLogin(){
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}

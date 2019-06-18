package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.dev.ilkeryildirim.triomobileinternproject.Adapter.RecyclerviewAdapter;
import com.dev.ilkeryildirim.triomobileinternproject.Model.UserContract;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;
import com.dev.ilkeryildirim.triomobileinternproject.R;
import com.dev.ilkeryildirim.triomobileinternproject.Model.UserPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserContract.Userview, MainActContract.View {


    private RecyclerView recyclerView;
    private UserPresenter userPresenter;
    private MainActPresenter mainActPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPresenter = new UserPresenter(this);
        mainActPresenter= new MainActPresenter(this);
        userPresenter.getUserResponse();



    }

    @Override
    public void userDataReady(List<User> users) {

        recyclerView = findViewById(R.id.users_recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerviewAdapter(users,getApplicationContext()));
        Log.v("asd",users.toString());
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
    }
}

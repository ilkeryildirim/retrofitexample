package com.dev.ilkeryildirim.triomobileinternproject.Activity.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.dev.ilkeryildirim.triomobileinternproject.Activity.Map.MapActivity;
import com.dev.ilkeryildirim.triomobileinternproject.Adapter.RecyclerviewAdapter;
import com.dev.ilkeryildirim.triomobileinternproject.Const;
import com.dev.ilkeryildirim.triomobileinternproject.Di.DaggerApplication;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;
import com.dev.ilkeryildirim.triomobileinternproject.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActContract.View, RecyclerviewAdapter.MyViewHolder.RecyclerViewClickListener {


    private RecyclerView recyclerView;
    private MainActPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        initViews();

    }

    @Override
    public void onUserResponseReady(List<User> users) {

        recyclerView.setAdapter(new RecyclerviewAdapter(users,this));
    }

    @Override
    public void showError(String error) {

        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onRecyclerClick(User user) {

        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra(Const.CLASS_USER_TAG,user);
        startActivity(intent);
    }

    @Override
    public void initVariables() {
        presenter.getUserResponse();
        presenter=new MainActPresenter(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);
    }

    @Override
    public void initViews() {

        recyclerView = findViewById(R.id.users_recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

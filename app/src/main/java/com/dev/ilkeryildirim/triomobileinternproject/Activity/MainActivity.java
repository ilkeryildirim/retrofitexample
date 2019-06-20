package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.dev.ilkeryildirim.triomobileinternproject.Adapter.RecyclerviewAdapter;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;
import com.dev.ilkeryildirim.triomobileinternproject.R;
import com.dev.ilkeryildirim.triomobileinternproject.SharedData;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActContract.View, RecyclerviewAdapter.MyViewHolder.RecyclerViewClickListener {


    private RecyclerView recyclerView;
    private List<User> userList;
    private MainActPresenter mainActPresenter;
    private SharedData sharedData;
    private User c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActPresenter= new MainActPresenter(this);
        mainActPresenter.getUserResponse();


    }

    @Override
    public void onUserResponseReady(List<User> users) {

        recyclerView = findViewById(R.id.users_recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerviewAdapter(users,this));
        this.userList=users;

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onRecyclerClick(int position) {
        c=userList.get(position);
        sharedData=new SharedData();
        sharedData.setUserfullname(c.getName());
        sharedData.setUsername(c.getUsername());
        sharedData.setMail(c.getEmail());
        sharedData.setCity(c.getAddress().getCity());
        sharedData.setSuite(c.getAddress().getSuite());
        sharedData.setStreet(c.getAddress().getStreet());
        sharedData.setLat(c.getAddress().getGeo().getLat());
        sharedData.setLng(c.getAddress().getGeo().getLng());

        Intent intent = new Intent(MainActivity.this,MapActivity.class);
        intent.putExtra("MyClass", sharedData);
        startActivity(intent);
    }
}

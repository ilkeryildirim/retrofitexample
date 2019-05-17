package com.dev.ilkeryildirim.triomobileinternproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> userList;
    private ArrayList<Address> addressList;
    private List<String> user_email;
    private List<String> street;
    private List<String> suite;
    private List<String> city;
    private List<String> lat;
    private List<String> lng;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        recyclerView = findViewById(R.id.users_recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiEndpointInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiEndpointInterface.class);

        Call<List<User>> callUser = apiInterface.getUsers();
        callUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = new ArrayList<>(response.body());
                recyclerView.setAdapter(new RecyclerviewAdapter(userList,getApplicationContext()));
                System.out.println("call user :" + userList);
                System.out.println("adress : "+addressList);
            }


            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}

package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import com.dev.ilkeryildirim.triomobileinternproject.ApiService.ApiEndpoint;
import com.dev.ilkeryildirim.triomobileinternproject.ApiService.RetrofitClient;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActPresenter implements MainActContract.Presenter {

    private MainActContract.View view;

    public ArrayList<User> usersList;
    public MainActPresenter(MainActContract.View view) {

        this.view = view;

    }

    @Override
    public void getUserResponse() {
        ApiEndpoint apiInterface = RetrofitClient.getRetrofitInstance().create(ApiEndpoint.class);

        Call<List<User>> callUser = apiInterface.getUsers();
        callUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                usersList= new ArrayList<>(response.body());
                view.onUserResponseReady(usersList);
            }


            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }

}


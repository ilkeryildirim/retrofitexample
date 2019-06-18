package com.dev.ilkeryildirim.triomobileinternproject.Model;

import com.dev.ilkeryildirim.triomobileinternproject.Activity.MainActContract;
import com.dev.ilkeryildirim.triomobileinternproject.ApiService.RetrofitClient;
import com.dev.ilkeryildirim.triomobileinternproject.ApiService.ApiEndpointInterface;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;
import com.dev.ilkeryildirim.triomobileinternproject.Model.UserContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter implements UserContract.Presenter{
    private MainActContract.View mainActview;
    private UserContract.Userview userview;
    public ArrayList<User> userList;

    public UserPresenter(UserContract.Userview view) {
        this.userview = view;
        this.mainActview= (MainActContract.View) view;

    }



    @Override
    public void getUserResponse() {
        ApiEndpointInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiEndpointInterface.class);

        Call<List<User>> callUser = apiInterface.getUsers();
        callUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList= new ArrayList<>(response.body());
                userview.userDataReady(userList);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                mainActview.showError(t.getLocalizedMessage());
            }
        });


    }


}

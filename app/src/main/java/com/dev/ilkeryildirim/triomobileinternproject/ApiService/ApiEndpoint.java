package com.dev.ilkeryildirim.triomobileinternproject.ApiService;

import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("users")
    Call<List<User>> getUsers();

}

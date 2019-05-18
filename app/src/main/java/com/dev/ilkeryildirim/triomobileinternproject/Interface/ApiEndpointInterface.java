package com.dev.ilkeryildirim.triomobileinternproject.Interface;

import com.dev.ilkeryildirim.triomobileinternproject.Models.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointInterface {

    @GET("users")
    Call<List<User>> getUsers();


}

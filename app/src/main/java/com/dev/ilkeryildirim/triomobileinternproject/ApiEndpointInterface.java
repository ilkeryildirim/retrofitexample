package com.dev.ilkeryildirim.triomobileinternproject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndpointInterface {

    @GET("users")
    Call<List<User>> getUsers();


}

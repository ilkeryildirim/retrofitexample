package com.dev.ilkeryildirim.triomobileinternproject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointInterface {

    @GET("users")
    Call<List<User>> getUsers();


}

package com.dev.ilkeryildirim.triomobileinternproject.Models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
     private String name;

    @SerializedName("username")
     private String username;

    @SerializedName("email")
     private String email;

    //Adress branch
    @SerializedName("address")
    private Address address;


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }


}

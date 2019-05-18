package com.dev.ilkeryildirim.triomobileinternproject.Model;

import com.google.gson.annotations.SerializedName;

public class Address {

   @SerializedName("street")
    private String street;

   @SerializedName("suite")
    private String suite;

   @SerializedName("city")
    private String city;

   //Geo branch
    @SerializedName("geo")
    private Geo geo;

    public Geo getGeo() {
        return geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }


}
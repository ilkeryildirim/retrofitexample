package com.dev.ilkeryildirim.triomobileinternproject.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Address implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.street);
        dest.writeString(this.suite);
        dest.writeString(this.city);
        dest.writeParcelable(this.geo, flags);
    }

    public Address() {
    }

    protected Address(Parcel in) {
        this.street = in.readString();
        this.suite = in.readString();
        this.city = in.readString();
        this.geo = in.readParcelable(Geo.class.getClassLoader());
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}

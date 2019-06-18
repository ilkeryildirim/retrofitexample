package com.dev.ilkeryildirim.triomobileinternproject.Adapter;

import android.content.Intent;

import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import java.util.ArrayList;

public class RecylerviewAdaperPresenter implements RecylerviewAdapterContract.Presenter {

    RecylerviewAdapterContract.View view;
    ArrayList<String> user_email= new ArrayList<String>();
    ArrayList<String> street= new ArrayList<String>();
    ArrayList<String> suite= new ArrayList<String>();
    ArrayList<String> city= new ArrayList<String>();
    ArrayList<String> lat= new ArrayList<String>();
    ArrayList<String> lng= new ArrayList<String>();
    ArrayList<String> username= new ArrayList<String>();
    ArrayList<String> name= new ArrayList<String>();

    public RecylerviewAdaperPresenter(RecylerviewAdapterContract.View view) {
        this.view = view;
    }


    @Override
    public void onBindRecylerViewHolder(User c) {

        suite.add(c.getAddress().getSuite());
        street.add(c.getAddress().getStreet());
        city.add(c.getAddress().getCity());
        user_email.add(c.getEmail());
        username.add(c.getUsername());
        name.add(c.getName());
        lat.add(c.getAddress().getGeo().getLat());
        lng.add(c.getAddress().getGeo().getLng());
    }

    @Override
    public void putStringsOnItemClick(int position, Intent i) {
        i.putExtra("email","E-mail: "+user_email.get(position));
        i.putExtra("suite","Suite: "+suite.get(position));
        i.putExtra("street","Street: "+street.get(position));
        i.putExtra("city","City: "+city.get(position));
        i.putExtra("lat",lat.get(position));
        i.putExtra("lng",lng.get(position));
        i.putExtra("fullname",name.get(position));
        i.putExtra("name","@"+username.get(position));
    }
}

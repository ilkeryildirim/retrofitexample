package com.dev.ilkeryildirim.triomobileinternproject.Di;

import android.app.Application;
import android.content.Context;

import com.dev.ilkeryildirim.triomobileinternproject.Model.Address;
import com.dev.ilkeryildirim.triomobileinternproject.Model.Geo;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import dagger.Provides;

@dagger.Module

public class UserModule {

    Context context;

    public UserModule(Application app) {
        this.context=app;
    }

    @Provides
    User provideUser(Address address){
       return new User(address);
    }
    @Provides
    Context provideContext(){
        return context;
    }

    @Provides
    Address provideAddress(Geo geo){
        return new Address(geo);
    }

}
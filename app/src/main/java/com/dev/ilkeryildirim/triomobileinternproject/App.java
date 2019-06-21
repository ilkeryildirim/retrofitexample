package com.dev.ilkeryildirim.triomobileinternproject;

import android.app.Application;

import com.dev.ilkeryildirim.triomobileinternproject.Di.UserComponent;
import com.dev.ilkeryildirim.triomobileinternproject.Di.DaggerComponent_Dagger2Comp;
import com.dev.ilkeryildirim.triomobileinternproject.Di.UserModule;

public class App extends Application {

    private UserComponent userComponent;

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public void setUserComponent(UserComponent userComponent) {
        this.userComponent = userComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        userComponent = (UserComponent) DaggerComponent_Dagger2Comp.builder().module(new UserModule(this)).build();

    }
}

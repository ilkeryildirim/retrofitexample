package com.dev.ilkeryildirim.triomobileinternproject.Di;

import android.app.Application;




public class DaggerApplication extends Application {

    private DaggerComponent daggerComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();

    }

    private void initializeInjector(){
        daggerComponent = DaggerDaggerComponent.builder()
                .daggerModule(new DaggerModule(this))
                .build();
    }

    public DaggerComponent getDaggerComponent(){
        return daggerComponent;
    }
}
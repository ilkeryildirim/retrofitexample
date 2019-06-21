package com.dev.ilkeryildirim.triomobileinternproject.Di;



import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {

    private final DaggerApplication daggerApplication;

    public DaggerModule(DaggerApplication daggerApplication) {
        this.daggerApplication = daggerApplication;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return daggerApplication;
    }



}
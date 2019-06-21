package com.dev.ilkeryildirim.triomobileinternproject.Di;


import dagger.Module;

@Module
public class DaggerModule {

    public DaggerModule(DaggerApplication daggerApplication) {
        this.daggerApplication = daggerApplication;
    }

    private final DaggerApplication daggerApplication;

}
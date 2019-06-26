package com.dev.ilkeryildirim.triomobileinternproject.Di;

import com.dev.ilkeryildirim.triomobileinternproject.Activity.Main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DaggerModule.class)

public interface DaggerComponent {
    void inject(MainActivity mainActivity);
}
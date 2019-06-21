package com.dev.ilkeryildirim.triomobileinternproject.Di;

import com.dev.ilkeryildirim.triomobileinternproject.Activity.MainActivity;
import com.dev.ilkeryildirim.triomobileinternproject.Activity.MapActivity;

import javax.inject.Singleton;

public class UserComponent {
    @Singleton
    @dagger.Component(modules = {UserModule.class})
    public interface Dagger2Comp {
        void injectMainAct(MainActivity mainActivity);
        void injectMapAct(MapActivity mapActivity);

    }
}

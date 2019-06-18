package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Context;

public interface MainActContract {

    interface View{

        void showError(String error);

    }

    interface Presenter{

        void loadError();

    }

}

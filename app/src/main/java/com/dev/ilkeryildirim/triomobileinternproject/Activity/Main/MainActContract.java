package com.dev.ilkeryildirim.triomobileinternproject.Activity.Main;
import com.dev.ilkeryildirim.triomobileinternproject.IBase;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import java.util.List;

public interface MainActContract {

    interface View extends IBase.View {

        void showError(String error);
        void onUserResponseReady(List<User> users);

    }

    interface Presenter{

        void getUserResponse();
    }

}

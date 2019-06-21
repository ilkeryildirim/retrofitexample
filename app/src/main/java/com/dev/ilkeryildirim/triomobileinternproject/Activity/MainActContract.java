package com.dev.ilkeryildirim.triomobileinternproject.Activity;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import java.util.List;

public interface MainActContract {

    interface View{

        void showError(String error);
        void onUserResponseReady(List<User> users);

    }

    interface Presenter{

        void getUserResponse();
        void loadError();

    }

}

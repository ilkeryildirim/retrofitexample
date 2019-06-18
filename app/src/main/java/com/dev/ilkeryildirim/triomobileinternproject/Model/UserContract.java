package com.dev.ilkeryildirim.triomobileinternproject.Model;

import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import java.util.List;

public interface UserContract {

    interface Presenter {

        void getUserResponse();


    }
    interface Userview {

        void userDataReady(List<User> users);

    }
}

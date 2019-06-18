package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import com.dev.ilkeryildirim.triomobileinternproject.Model.UserContract;
import com.dev.ilkeryildirim.triomobileinternproject.Model.UserPresenter;

public class MainActPresenter implements MainActContract.Presenter {
    private UserPresenter userPresenter;
    private MainActContract.View view;


    public MainActPresenter(MainActContract.View view) {
        this.userPresenter = new UserPresenter((UserContract.Userview) view);
        this.view = view;

    }

    @Override
    public void loadError() {

        view.showError("a");

    }

}


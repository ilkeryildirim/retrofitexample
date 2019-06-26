package com.dev.ilkeryildirim.triomobileinternproject.Activity.Profile;

import com.dev.ilkeryildirim.triomobileinternproject.Activity.Map.ProfileActivityContract;

public class ProfileActivityPresenter implements ProfileActivityContract.Presenter {

    private ProfileActivityContract.View view;

    public ProfileActivityPresenter(ProfileActivityContract.View view) {
        this.view = view;
    }


}

package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.widget.TextView;


public class MapActPresenter implements MapActContract.Presenter {

    public MapActPresenter(MapActContract.View view) {
        this.view = view;
    }

    MapActContract.View view;

    @Override
    public void onSetItems() {

        view.SetItems();


    }


}

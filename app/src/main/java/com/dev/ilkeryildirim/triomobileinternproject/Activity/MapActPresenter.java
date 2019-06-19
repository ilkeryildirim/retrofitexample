package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.widget.TextView;

import com.dev.ilkeryildirim.triomobileinternproject.R;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


public class MapActPresenter implements MapActContract.Presenter {

    public MapActPresenter(MapActContract.View view) {
        this.view = view;
    }

    MapActContract.View view;

    @Override
    public void SetItems() {

        view.onSetItems();


    }

    @Override
    public void initMap(OnMapReadyCallback onMapReadyCallback,SupportMapFragment supportMapFragment) {

        supportMapFragment.getMapAsync(onMapReadyCallback);

    }


}

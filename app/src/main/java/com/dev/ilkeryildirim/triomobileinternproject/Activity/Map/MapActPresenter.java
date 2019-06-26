package com.dev.ilkeryildirim.triomobileinternproject.Activity.Map;



public class MapActPresenter implements MapActContract.Presenter {

    MapActContract.View view;


    public MapActPresenter(MapActContract.View view) {
        this.view = view;
    }

}

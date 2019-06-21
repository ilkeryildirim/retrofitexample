package com.dev.ilkeryildirim.triomobileinternproject.Activity;



public class MapActPresenter implements MapActContract.Presenter {


    public MapActPresenter(MapActContract.View view) {
        this.view = view;
    }

    MapActContract.View view;


    @Override
    public void created() {

        view.getSharedData();

    }



}

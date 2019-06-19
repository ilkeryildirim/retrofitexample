package com.dev.ilkeryildirim.triomobileinternproject.Adapter;


import com.google.android.gms.maps.OnMapReadyCallback;

public class RecylerviewAdaperPresenter implements RecylerviewAdapterContract.Presenter {

    RecylerviewAdapterContract.View view;


    public RecylerviewAdaperPresenter(RecylerviewAdapterContract.View view) {
        this.view = view;
    }


    @Override
    public void onBindRecylerViewHolder() {

        view.bindViews();
    }

    @Override
    public void putStringsOnItemClick(int position) {
        view.putStrings(position);

    }



}

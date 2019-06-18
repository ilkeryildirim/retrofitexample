package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.widget.TextView;


public class MapActPresenter implements MapActContract.Presenter {


    @Override
    public void setItems(Intent intent
            ,TextView nameTV
            ,TextView mailTv
            ,TextView user_fullnameTv
            ,TextView streetTv
            ,TextView suiteTv
            ,TextView cityTv
            ,String lat
            ,String lng) {

        suiteTv.setText(intent.getStringExtra("suite"));
        streetTv.setText(intent.getStringExtra("street"));
        mailTv.setText(intent.getStringExtra("email"));
        cityTv.setText(intent.getStringExtra("city"));
        nameTV.setText(intent.getStringExtra("name"));
        user_fullnameTv.setText(intent.getStringExtra("fullname"));
        lat= intent.getStringExtra("lat");
        lng= intent.getStringExtra("lng");



    }
}

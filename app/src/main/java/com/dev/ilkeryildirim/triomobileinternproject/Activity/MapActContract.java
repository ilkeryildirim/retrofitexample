package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.widget.TextView;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public interface MapActContract {


    interface View{

      void SetItems();
    }

    interface Presenter{

     void onSetItems();
     void initMap(OnMapReadyCallback onMapReadyCallback,
                  SupportMapFragment supportMapFragment);

    }

}

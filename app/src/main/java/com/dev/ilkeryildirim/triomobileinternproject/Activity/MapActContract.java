package com.dev.ilkeryildirim.triomobileinternproject.Activity;


import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public interface MapActContract {


    interface View{

      void getSharedData();
    }

    interface Presenter{

     void created();


    }

}

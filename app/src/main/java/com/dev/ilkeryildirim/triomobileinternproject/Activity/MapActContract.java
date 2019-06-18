package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.widget.TextView;

public interface MapActContract {


    interface View{


    }

    interface Presenter{

     void setItems(Intent intent
                ,TextView nameTV
                ,TextView mailTv
                ,TextView user_fullnameTv
                ,TextView streetTv
                ,TextView suiteTv
                ,TextView cityTv
                ,String lat
                ,String lng);
    }

}

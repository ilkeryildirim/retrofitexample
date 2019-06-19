package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.widget.TextView;

public interface MapActContract {


    interface View{

      void SetItems();
    }

    interface Presenter{

     void onSetItems();
    }

}

package com.dev.ilkeryildirim.triomobileinternproject.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dev.ilkeryildirim.triomobileinternproject.Model.User;

import java.util.List;

public interface RecylerviewAdapterContract {


    interface Presenter{

    void onBindRecylerViewHolder(User c);
    void putStringsOnItemClick(int position, Intent i);

    }

    interface View{


    }
}

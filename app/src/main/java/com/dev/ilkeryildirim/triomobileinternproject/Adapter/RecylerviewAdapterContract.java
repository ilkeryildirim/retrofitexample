package com.dev.ilkeryildirim.triomobileinternproject.Adapter;



public interface RecylerviewAdapterContract {


    interface Presenter{

    void onBindRecylerViewHolder();
    void putStringsOnItemClick(int position);

    }

    interface View{

        void bindViews();
        void putStrings(int itemposition);


    }
}

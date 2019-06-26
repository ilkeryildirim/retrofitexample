package com.dev.ilkeryildirim.triomobileinternproject.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.ilkeryildirim.triomobileinternproject.Model.CustomData;
import com.dev.ilkeryildirim.triomobileinternproject.R;

import java.util.List;


public class FoundsRecyclerView extends RecyclerView.Adapter<FoundsRecyclerView.FoundsViewHolder> {

    private List<CustomData> foundList;
    private CustomData c;


    public static class FoundsViewHolder extends RecyclerView.ViewHolder {

        public FoundsViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public FoundsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_founds_item_custom, viewGroup, false);
        FoundsViewHolder fvh = new FoundsViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(FoundsViewHolder foundsViewHolder, int i) {
     c=foundList.get(i);

    }


    @Override
    public int getItemCount() {
        return foundList.size();
    }

    public FoundsRecyclerView(List<CustomData> foundList) {
        this.foundList = foundList;
    }


}
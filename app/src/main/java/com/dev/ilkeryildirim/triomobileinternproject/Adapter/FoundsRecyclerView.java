package com.dev.ilkeryildirim.triomobileinternproject.Adapter;


import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.ilkeryildirim.triomobileinternproject.Model.CustomData;
import com.dev.ilkeryildirim.triomobileinternproject.R;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FoundsRecyclerView extends RecyclerView.Adapter<FoundsRecyclerView.MyViewHolder>  {

    private static List<CustomData> foundList;
    private MyViewHolder.RecyclerViewClickListener recyclerViewClickListener;
    private CustomData c;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.item_found_nameTextView) TextView foundName;
        @BindView(R.id.item_found_explainTextView) TextView foundExplainText;
        @BindView(R.id.item_foundGoalTextView) TextView foundGoal;
        @BindView(R.id.item_found_totalTextView) TextView foundTotal;
        @BindView(R.id.item_founderCountTextview) TextView founderCount;
       // @BindView(R.id.progressBar) ProgressBar progressBar;

        RecyclerViewClickListener recyclerViewClickListener;
        public MyViewHolder(View view,RecyclerViewClickListener recyclerViewClickListener) {
            super(view);
            ButterKnife.bind(this,view);
            this.recyclerViewClickListener=recyclerViewClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


            recyclerViewClickListener.onRecyclerClick(foundList.get(getAdapterPosition()));
        }

        public interface RecyclerViewClickListener{

            void onRecyclerClick(CustomData customData);

        }
    }

    public FoundsRecyclerView(List<CustomData> founds, MyViewHolder.RecyclerViewClickListener recyclerViewClickListener) {

        this.foundList = founds;
        this.recyclerViewClickListener=recyclerViewClickListener;

    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        c = foundList.get(position);

        holder.foundName.setText(c.getFoundName());
        holder.founderCount.setText(String.valueOf(c.getFoundersCount()));
        holder.foundExplainText.setText(c.getFoundExplainText());
        holder.foundGoal.setText(String.valueOf(c.getFoundGoal()));
        holder.foundTotal.setText(String.valueOf(c.getFoundTotal()));
/*
            holder.progressBar.setMax(100);
            holder.progressBar.setProgress(50);
            System.out.println("asdddddddddddddddddddddddd");
*/

    }

    @Override
    public int getItemCount() {
        return foundList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_founds_item_custom,parent, false);

        return new MyViewHolder(v,recyclerViewClickListener);

    }
}

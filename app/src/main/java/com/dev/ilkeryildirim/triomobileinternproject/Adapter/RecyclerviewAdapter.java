package com.dev.ilkeryildirim.triomobileinternproject.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;
import com.dev.ilkeryildirim.triomobileinternproject.R;


import java.util.List;

import butterknife.BindView;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>  {

    private List<User> userList;
    private MyViewHolder.RecyclerViewClickListener recyclerViewClickListener;
    private User c;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.username_tv)
        TextView user_name;
        @BindView(R.id.userfullname_tv)
        TextView user_fullname;

        RecyclerViewClickListener recyclerViewClickListener;
        public MyViewHolder(View view,RecyclerViewClickListener recyclerViewClickListener) {
            super(view);
            user_name = view.findViewById(R.id.username_tv);
            user_fullname =  view.findViewById(R.id.userfullname_tv);
            this.recyclerViewClickListener=recyclerViewClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            recyclerViewClickListener.onRecyclerClick(getAdapterPosition());
        }

        public interface RecyclerViewClickListener{

            void onRecyclerClick(int position);
        }
    }

    public RecyclerviewAdapter(List<User> userList, MyViewHolder.RecyclerViewClickListener recyclerViewClickListener) {

        this.userList = userList;
        this.recyclerViewClickListener=recyclerViewClickListener;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        c = userList.get(position);

        holder.user_name.setText(c.getUsername());
        holder.user_fullname.setText(c.getName());


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_custom,parent, false);
        return new MyViewHolder(v,recyclerViewClickListener);

    }
}

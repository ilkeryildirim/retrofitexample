package com.dev.ilkeryildirim.triomobileinternproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.ilkeryildirim.triomobileinternproject.Activity.MapActivity;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;
import com.dev.ilkeryildirim.triomobileinternproject.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> implements RecylerviewAdapterContract.View   {



    private List<User> userList;
    private RecylerviewAdaperPresenter presenter;

    private User c;
    Context ctx;
    View mView;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView user_name;
        public TextView user_fullname;


        public MyViewHolder(View view) {

            super(view);

            mView=view;
            user_name = (TextView) view.findViewById(R.id.username_tv);
            user_fullname = (TextView) view.findViewById(R.id.userfullname_tv);

        }
    }

    public RecyclerviewAdapter(List<User> userList,Context applicationContext) {
        presenter= new RecylerviewAdaperPresenter(this);
        this.userList = userList;
        this.ctx=applicationContext;

    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        c = userList.get(position);

        presenter.onBindRecylerViewHolder(c);

        holder.user_fullname.setText(c.getName());
        holder.user_name.setText("@"+c.getUsername());



        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View aView = v;

                ctx=holder.itemView.getContext();Intent i = new Intent(ctx, MapActivity.class);
                presenter.putStringsOnItemClick(position,i);
                ctx.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {

        return userList.size();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_custom,parent, false);
        return new MyViewHolder(v);

    }
}

package com.dev.ilkeryildirim.triomobileinternproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private List<User> userList;
    private ArrayList<String> user_email= new ArrayList<String>();
    private ArrayList<String> street= new ArrayList<String>();
    private ArrayList<String> suite= new ArrayList<String>();
    private ArrayList<String> city= new ArrayList<String>();
    private ArrayList<String> lat= new ArrayList<String>();
    private ArrayList<String> lng= new ArrayList<String>();
    private ArrayList<String> username= new ArrayList<String>();
    private ArrayList<String> name= new ArrayList<String>();
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

        this.userList = userList;
        this.ctx=applicationContext;

    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        c = userList.get(position);
        holder.user_fullname.setText(c.getName());
        holder.user_name.setText("@"+c.getUsername());
        suite.add(c.getAddress().getSuite());
        street.add(c.getAddress().getStreet());
        city.add(c.getAddress().getCity());
        user_email.add(c.getEmail());
        username.add(c.getUsername());
        name.add(c.getName());
        lat.add(c.getAddress().getGeo().getLat());
        lng.add(c.getAddress().getGeo().getLng());

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx=holder.itemView.getContext();
                Intent i = new Intent(ctx, MapActivity.class);
                i.putExtra("email","E-mail: "+user_email.get(position));
                i.putExtra("suite","Suite: "+suite.get(position));
                i.putExtra("street","Street: "+street.get(position));
                i.putExtra("city","City: "+city.get(position));
                i.putExtra("lat",lat.get(position));
                i.putExtra("lng",lng.get(position));
                i.putExtra("fullname",name.get(position));
                i.putExtra("name","@"+username.get(position));
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

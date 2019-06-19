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
import java.util.Map;

import butterknife.BindView;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> implements RecylerviewAdapterContract.View   {

    private List<User> userList;
    ArrayList<String> user_email= new ArrayList<String>();
    ArrayList<String> street= new ArrayList<String>();
    ArrayList<String> suite= new ArrayList<String>();
    ArrayList<String> city= new ArrayList<String>();
    ArrayList<String> lat= new ArrayList<String>();
    ArrayList<String> lng= new ArrayList<String>();
    ArrayList<String> username= new ArrayList<String>();
    ArrayList<String> name= new ArrayList<String>();
    private RecylerviewAdapterContract.Presenter presenter;


    private User c;
    Context ctx;
    View mView;

    @Override
    public void bindViews() {

        suite.add(c.getAddress().getSuite());
        street.add(c.getAddress().getStreet());
        city.add(c.getAddress().getCity());
        user_email.add(c.getEmail());
        username.add(c.getUsername());
        name.add(c.getName());
        lat.add(c.getAddress().getGeo().getLat());
        lng.add(c.getAddress().getGeo().getLng());

    }

    @Override
    public void putStrings(int itemposition) {

        Intent i= new Intent(ctx, MapActivity.class);
        i.putExtra("email","E-mail: "+user_email.get(itemposition));
        i.putExtra("suite","Suite: "+suite.get(itemposition));
        i.putExtra("street","Street: "+street.get(itemposition));
        i.putExtra("city","City: "+city.get(itemposition));
        i.putExtra("lat",lat.get(itemposition));
        i.putExtra("lng",lng.get(itemposition));
        i.putExtra("fullname",name.get(itemposition));
        i.putExtra("name","@"+username.get(itemposition));

        System.out.println("111111111111111111111111111+ :"+street.get(itemposition));


    }




    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView user_name;
        public TextView user_fullname;


        public MyViewHolder(View view) {

            super(view);

            mView=view;
            user_name = view.findViewById(R.id.username_tv);
            user_fullname =  view.findViewById(R.id.userfullname_tv);
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
        presenter.onBindRecylerViewHolder();

        holder.user_fullname.setText(c.getName());
        holder.user_name.setText("@"+c.getUsername());
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ctx=holder.itemView.getContext();Intent i = new Intent(ctx, MapActivity.class);
                presenter.putStringsOnItemClick(position);
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

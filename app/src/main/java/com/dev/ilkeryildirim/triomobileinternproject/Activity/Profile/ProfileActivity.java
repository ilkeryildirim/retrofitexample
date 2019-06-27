package com.dev.ilkeryildirim.triomobileinternproject.Activity.Profile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;


import com.dev.ilkeryildirim.triomobileinternproject.Activity.Map.ProfileActivityContract;
import com.dev.ilkeryildirim.triomobileinternproject.Adapter.FoundsRecyclerView;
import com.dev.ilkeryildirim.triomobileinternproject.Model.CustomData;
import com.dev.ilkeryildirim.triomobileinternproject.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements ProfileActivityContract.View, FoundsRecyclerView.MyViewHolder.RecyclerViewClickListener {


    private RecyclerView foundsRecyclerView;
    private Toolbar mToolbar;


    private List<CustomData> founds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initializeData();
        initVariables();
        initViews();

    }

    @Override
    public void initVariables() {


    }

    @Override
    public void initViews() {
        foundsRecyclerView=findViewById(R.id.found_recyclerView);
        mToolbar= findViewById(R.id.profile_app_bar);
        foundsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        foundsRecyclerView.setAdapter(new FoundsRecyclerView(founds,this));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onRecyclerClick(CustomData customData) {

    }

    private void initializeData(){
        founds = new ArrayList<>();
        founds.add(new CustomData("Bus station for town",
                "We need your help for a new school",
                3,
                2100,
                50000,
                R.drawable.facebookicon));
        founds.add(new CustomData("School for childrens",
                "We need your help for a new school We need your help for a new school",
                4,
                1250,
                25000,
                R.drawable.facebookicon));
        founds.add(new CustomData("School for childrens",
                "We need your help for a new school",
                3,
                4140,
                29000,
                R.drawable.facebookicon));
        founds.add(new CustomData("School for childrens",
                "We need your help for a new school",
                5,
                9000,
                50000,
                R.drawable.facebookicon));
        founds.add(new CustomData("School for childrens",
                "We need your help for a new school",
                9,
                15000,
                50000,
                R.drawable.facebookicon));
        founds.add(new CustomData("School for childrens",
                "We need your help for a new schoolWe need your help for a new schoolWe need your help for a new school",
                3,
                2100,
                50000,
                R.drawable.facebookicon));


    }
}

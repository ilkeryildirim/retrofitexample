package com.dev.ilkeryildirim.triomobileinternproject.Activity.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.dev.ilkeryildirim.triomobileinternproject.Activity.Map.ProfileActivityContract;
import com.dev.ilkeryildirim.triomobileinternproject.R;

public class ProfileActivity extends AppCompatActivity implements ProfileActivityContract.View {

    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initVariables();
        initViews();

    }

    @Override
    public void initVariables() {
        mToolbar=findViewById(R.id.profile_app_bar);

    }

    @Override
    public void initViews() {

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}

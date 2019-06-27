package com.dev.ilkeryildirim.triomobileinternproject.Activity.Map;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dev.ilkeryildirim.triomobileinternproject.Const;
import com.dev.ilkeryildirim.triomobileinternproject.Model.User;
import com.dev.ilkeryildirim.triomobileinternproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback,MapActContract.View {


    private GoogleMap mMap;
    private User user;
    @BindView(R.id.map_usermailTv) TextView mailTv;
    @BindView(R.id.map_user_nameTv) TextView nameTV;
    @BindView(R.id.map_user_fullnameTv) TextView user_fullnameTv;
    @BindView(R.id.map_streetTv) TextView streetTv;
    @BindView(R.id.map_suiteTv) TextView suiteTv;
    @BindView(R.id.map_cityTv) TextView cityTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initVariables();
        initViews();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng userLocation = new LatLng(Double.parseDouble(user.getAddress().getGeo().getLat()), Double.parseDouble(user.getAddress().getGeo().getLng()));
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
    }

    @Override
    public void initVariables() {

        Intent i= getIntent();
        user = i.getParcelableExtra(Const.CLASS_USER_TAG);
    }

    @Override
    public void initViews() {

        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mailTv.setText(user.getEmail());
        nameTV.setText(user.getName());
        user_fullnameTv.setText(user.getUsername());
        streetTv.setText(user.getAddress().getStreet());
        suiteTv.setText(user.getAddress().getSuite());
        cityTv.setText(user.getAddress().getCity());
    }
}
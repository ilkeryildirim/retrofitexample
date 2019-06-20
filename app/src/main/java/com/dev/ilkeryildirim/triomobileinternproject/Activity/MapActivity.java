package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dev.ilkeryildirim.triomobileinternproject.R;
import com.dev.ilkeryildirim.triomobileinternproject.SharedData;
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
    private MapActContract.Presenter presenter;
    private SharedData sharedData;


    @BindView(R.id.map_usermailTv)
    TextView mailTv;
    @BindView(R.id.map_user_nameTv)
    TextView nameTV;
    @BindView(R.id.map_user_fullnameTv)
    TextView user_fullnameTv;
    @BindView(R.id.map_streetTv)
    TextView streetTv;
    @BindView(R.id.map_suiteTv)
    TextView suiteTv;
    @BindView(R.id.map_cityTv)
    TextView cityTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        presenter = new MapActPresenter(MapActivity.this);
        presenter.created();


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng userLocation = new LatLng(Double.parseDouble(sharedData.getLat()), Double.parseDouble(sharedData.getLng()));
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));


    }


    @Override
    public void getSharedData() {
        Intent i= getIntent();
        sharedData = (SharedData) i.getSerializableExtra("MyClass");

        mailTv.setText(sharedData.getMail());
        nameTV.setText(sharedData.getUsername());
        user_fullnameTv.setText(sharedData.getUserfullname());
        streetTv.setText(sharedData.getStreet());
        suiteTv.setText(sharedData.getSuite());
        cityTv.setText(sharedData.getCity());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
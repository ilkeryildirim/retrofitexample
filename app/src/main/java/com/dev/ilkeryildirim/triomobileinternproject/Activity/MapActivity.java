package com.dev.ilkeryildirim.triomobileinternproject.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dev.ilkeryildirim.triomobileinternproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{

    private TextView nameTV,mailTv,user_fullnameTv,streetTv,suiteTv,cityTv;
    private String lat,lng;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mailTv=findViewById(R.id.map_usermailTv);
        user_fullnameTv=findViewById(R.id.map_user_fullnameTv);
        streetTv=findViewById(R.id.map_streetTv);
        suiteTv=findViewById(R.id.map_suiteTv);
        cityTv=findViewById(R.id.map_cityTv);
        nameTV=findViewById(R.id.map_user_nameTv);

        Intent intent=getIntent();
        suiteTv.setText(intent.getStringExtra("suite"));
        streetTv.setText(intent.getStringExtra("street"));
        mailTv.setText(intent.getStringExtra("email"));
        cityTv.setText(intent.getStringExtra("city"));
        nameTV.setText(intent.getStringExtra("name"));
        user_fullnameTv.setText(intent.getStringExtra("fullname"));
        lat= intent.getStringExtra("lat");
        lng= intent.getStringExtra("lng");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng userLocation = new LatLng(Double.parseDouble(lng), Double.parseDouble(lat));
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

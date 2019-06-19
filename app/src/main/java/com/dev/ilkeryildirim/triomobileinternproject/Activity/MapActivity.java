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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback,MapActContract.View {


    private String lat, lng;
    private GoogleMap mMap;
    private MapActContract.Presenter presenter;
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

        presenter = new MapActPresenter(MapActivity.this);
        presenter.created();


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        /**
         mMap = googleMap;
        LatLng userLocation = new LatLng(Double.parseDouble(lng), Double.parseDouble(lat));
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation)); **/


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }


    @Override
    public void SetItems() {

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        presenter.initMap(this,mapFragment);
        Intent intent = getIntent();
        System.out.println(intent.getStringExtra("suite"));
        suiteTv.setText(intent.getStringExtra("suite"));
        streetTv.setText(intent.getStringExtra("street"));
        mailTv.setText(intent.getStringExtra("email"));
        cityTv.setText(intent.getStringExtra("city"));
        nameTV.setText(intent.getStringExtra("name"));
        user_fullnameTv.setText(intent.getStringExtra("fullname"));
        lat = intent.getStringExtra("lat");
        lng = intent.getStringExtra("lng");
    }
}
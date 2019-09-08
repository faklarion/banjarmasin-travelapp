package com.studio.faisal.banjarmasin.Lokasi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.studio.faisal.banjarmasin.R;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent i = getIntent();
        LatLng ll = i.getParcelableExtra("longLat_dataProvider");

        mMap = googleMap;
        if (i != null && ll != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(ll.latitude, ll.longitude), 18));
            LatLng defaultLoc = new LatLng(ll.latitude, ll.longitude);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLoc));
            mMap.addMarker(new MarkerOptions().position(defaultLoc));
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}

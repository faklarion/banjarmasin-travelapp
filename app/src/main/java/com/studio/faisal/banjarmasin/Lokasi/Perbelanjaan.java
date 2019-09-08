package com.studio.faisal.banjarmasin.Lokasi;

/**
 * Created by Faisal on 21/02/2019.
 */
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.studio.faisal.banjarmasin.R;

import java.util.ArrayList;
import java.util.List;


public class Perbelanjaan extends AppCompatActivity {
    List<ListData> productList;
    //the recyclerview
    RecyclerView recyclerView;
    private static Context mContext;

    public void bukapeta(double lat, double lo) {
        double newLat = lat;
        double newLong = lo;
        LatLng fromPosition = new LatLng(newLat,newLong);
        Bundle args = new Bundle();
        args.putParcelable("longLat_dataProvider", fromPosition);
        Intent i = new Intent(Perbelanjaan.this, MapsActivity.class);
        i.putExtras(args);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Pusat Perbelanjaan");
        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Pasar Terapung Siring",
                        "Jl. Kapt Tendean No.20, Gadang, Banjarmasin Tengah, Kota Banjarmasin",
                        R.drawable.psir));

        productList.add(
                new ListData(
                        1,
                        "Pasar Terapung Lok Baintan",
                        "Jalan Sungai Martapura, Desa Sungai Tandipah, Kecamatan Sungai Tabuk,  Banjar",
                        R.drawable.lokbain));

        productList.add(
                new ListData(
                        1,
                        "Sentra Antasari",
                        "Jl. Pangeran Antasari, Kelayan Luar, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70234",
                        R.drawable.antasari));
        productList.add(
                new ListData(
                        1,
                        "Dutamall dan Transmart Banjarmasin",
                        "Jl. A. Yani, Sungai Baru, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 701222",
                        R.drawable.transmart));


        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override
            public void onFabClick(View v, int position) {
                if (position == 0) {
                    bukapeta(-3.319467, 114.593344);
                } else if (position == 1) {
                    bukapeta(-3.290275, 114.661608);
                } else if (position == 2) {
                    bukapeta(-3.328595, 114.598726);
                } else if (position == 3) {
                    bukapeta(-3.322915, 114.603033);
                }
            }
        });
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

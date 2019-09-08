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




public class Resto extends AppCompatActivity{
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
        Intent i = new Intent(Resto.this, MapsActivity.class);
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
        getSupportActionBar().setTitle("Restoran");
        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Rumah Sambal Acan Raja Banjar",
                        "Jl. RE Martadinata No.3-1, Telawang, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70112",
                        R.drawable.sambal));

        productList.add(
                new ListData(
                        1,
                        "Waroeng Pondok Bahari",
                        "Jl. Simp. Kapt. Piere Tedean, RT.016/RW.002, Kelurahan Gadang, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70231",
                        R.drawable.pondokbahari));

        productList.add(
                new ListData(
                        1,
                        "Soto Bawah Jembatan",
                        "Jl. Banua Anyar, Benua Anyar, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70239",
                        R.drawable.soto));


        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override

            public void onFabClick(View v, int position) {
                if (position == 0) {
                    bukapeta(-3.327560, 114.589736);
                } else if (position == 1) {
                    bukapeta(-3.317857, 114.594595);
                } else if (position == 2) {
                    bukapeta(-3.304733, 114.610117);
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

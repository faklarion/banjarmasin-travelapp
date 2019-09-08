package com.studio.faisal.banjarmasin.Lokasi;

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



/**
 * Created by Faisal on 19/02/2019.
 */

public class Ibadah extends AppCompatActivity {
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
        Intent i = new Intent(Ibadah.this, MapsActivity.class);
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
        //initializing the productlist
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tempat Ibadah");
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Mesjid Sabilal Muhtadin",
                        "Jalan Jendral Sudirman No.1, Antasan Besar, Banjarmasin Tengah, Antasan Besar, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70114",
                        R.drawable.sabilal));

        productList.add(
                new ListData(
                        1,
                        "Gereja Katedral Banjarmasin",
                        "Jl. Lambung Mangkurat, Kertak Baru Ilir, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70231",
                        R.drawable.gereja));


        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override
            public void onFabClick(View v, int position) {
                if (position == 0) {
                    bukapeta(-3.318937, 114.591289);
                } else if (position == 1) {
                    bukapeta(-3.324497, 114.590591);
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

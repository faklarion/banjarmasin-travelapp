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


public class Terminal extends AppCompatActivity {
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
        Intent i = new Intent(Terminal.this, MapsActivity.class);
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
        getSupportActionBar().setTitle("Terminal Transportasi");
        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Bandar Udara Syamsudin Noor",
                        "Koperasi Bandara, Jl. Kasturi II No.10, Landasan Ulin Utara, Ulin, Kota Banjar Baru, Kalimantan Selatan 70713",
                        R.drawable.bandara));

        productList.add(
                new ListData(
                        1,
                        "Terminal KM 6 Banjarmasin",
                        "Jalan Pramuka KM 6 Banjarmasin",
                        R.drawable.terminall));

        productList.add(
                new ListData(
                        1,
                        "Pelabuhan Trisakti Banjarmasin",
                        "Komplek Pelabuhan Trisakti, Jalan Barito Hilir, Banjarmasin Barat, Telaga Biru, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70118",
                        R.drawable.trisakti));


        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override
            public void onFabClick(View v, int position) {
                if (position == 0) {
                    bukapeta(-3.439045, 114.754786);
                } else if (position == 1) {
                    bukapeta(-3.347709, 114.627204);
                } else if (position == 2) {
                    bukapeta(-3.327552, 114.558208);
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

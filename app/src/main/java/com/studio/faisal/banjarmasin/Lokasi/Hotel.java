package com.studio.faisal.banjarmasin.Lokasi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.location.LocationListener;

import com.google.android.gms.maps.model.LatLng;
import com.studio.faisal.banjarmasin.MainActivity;
import com.studio.faisal.banjarmasin.R;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends AppCompatActivity {

    List<com.studio.faisal.banjarmasin.Lokasi.ListData> productList;
    //the recyclerview
    RecyclerView recyclerView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public void bukapeta(double lat, double lo) {
        double newLat = lat;
        double newLong = lo;
        LatLng fromPosition = new LatLng(newLat,newLong);
        Bundle args = new Bundle();
        args.putParcelable("longLat_dataProvider", fromPosition);
        Intent i = new Intent(Hotel.this, MapsActivity.class);
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Hotel");

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new com.studio.faisal.banjarmasin.Lokasi.ListData(
                        1,
                        "Hotel Banjarmasin International",
                        "Jalan Jenderal Ahmad Yani Km. 4,5, Karang Mekar, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70234",
                        R.drawable.hbi));

        productList.add(
                new com.studio.faisal.banjarmasin.Lokasi.ListData(
                        1,
                        "G' Sign Hotel Banjarmasin",
                        "Jl. A. Yani KM 4,5 No.448, Pemurus Luar, Banjarmasin Timur, Pemurus Luar, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70238",
                        R.drawable.gsign));

        productList.add(
                new com.studio.faisal.banjarmasin.Lokasi.ListData(
                        1,
                        "Mercure Banjarmasin",
                        "Jalan Achmad Yani No.KM.2 No.98, Sungai Baru, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70232",
                        R.drawable.mercure));

        productList.add(
                new com.studio.faisal.banjarmasin.Lokasi.ListData(
                        1,
                        "Swiss-belHotel Banjarmasin",
                        "Jl. Pangeran Antasari No.86A, Banjarmasin",
                        R.drawable.swiss));




        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override
            public void onFabClick(View v, int position) {
                if (position == 0 ) {
                    bukapeta(-3.336619,114.616183);
                } else if (position == 1 ) {
                    bukapeta(-3.339234, 114.618745);
                } else if (position == 2 ) {
                    bukapeta(-3.323104, 114.603453);
                } else if (position == 3 ) {
                    bukapeta(-3.326735, 114.595799);
                }
            }
        });


        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

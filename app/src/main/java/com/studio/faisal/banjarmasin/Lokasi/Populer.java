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



public class Populer extends AppCompatActivity {
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
        Intent i = new Intent(Populer.this, MapsActivity.class);
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
        getSupportActionBar().setTitle("Tempat Populer");
        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Taman Siring 0 KM Banjarmasin",
                        "Jl. Jendral Sudirman, Antasan Besar, Banjarmasin Tengah, Antasan Besar, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70123",
                        R.drawable.siring));

        productList.add(
                new ListData(
                        1,
                        "Amanah Borneo Park",
                        "Jalan Taruna Bhakti, RT.12 RW.04, Palam, Cempaka, Palam, Cempaka, Kota Banjar Baru, Kalimantan Selatan 70731",
                        R.drawable.amanah));

        productList.add(
                new ListData(
                        1,
                        "Menara Pandang Banjarmasin",
                        "Jalan Kapten Tendean No. 07, RT. 16/RW. 02, Gadang, Banjarmasin Tengah, Kota Banjarmasin",
                        R.drawable.pandang));

        productList.add(
                new ListData(
                        1,
                        "Jembatan Barito",
                        "Jalan Trans Kalimantan, Marabahan Baru, Anjir Muara, Kabupaten Barito Kuala",
                        R.drawable.barito));

        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override

            public void onFabClick(View v, int position) {
                if (position == 0) {
                    bukapeta(-3.314921, 114.592535);
                } else if (position == 1) {
                    bukapeta(-3.495604, 114.808732);
                } else if (position == 2) {
                    bukapeta(-3.316829, 114.593102);
                } else if (position == 3) {
                    bukapeta(-3.214973, 114.557906);
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

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


public class RS extends AppCompatActivity {
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
        Intent i = new Intent(RS.this, MapsActivity.class);
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
        getSupportActionBar().setTitle("Rumah Sakit");
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Rumah Sakit Umum Daerah Ulin",
                        "Jalan A. Yani No. 43, Sungai Baru, Banjarmasin Tengah, Sungai Baru, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70233",
                        R.drawable.rsulin));

        productList.add(
                new ListData(
                        1,
                        "RSUD Dr. H. Moch. Ansari Saleh",
                        "Jl. Brig. Jend. H. Hasan Basri No. 1, Alalak Utara, Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70125",
                        R.drawable.rsas));

        productList.add(
                new ListData(
                        1,
                        "Rumah Sakit Sari Mulia",
                        "Jalan Pangeran Antasari No.139, Sungai Baru, Banjarmasin Tengah, Sungai Baru, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70233",
                        R.drawable.rssm));


        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override
            public void onFabClick(View v, int position) {
                if (position == 0) {
                    bukapeta(-3.322830, 114.601190);
                } else if (position == 1) {
                    bukapeta(-3.278106, 114.587703);
                } else if (position == 2) {
                    bukapeta(-3.327668, 114.605190);
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

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



public class Bank extends AppCompatActivity {
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
        Intent i = new Intent(Bank.this, MapsActivity.class);
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
        getSupportActionBar().setTitle("Bank");

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Bank Indonesia",
                        "Jl. Lambung Mangkurat No.15, Kertak Baru Ulu, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70111",
                        R.drawable.bankindo));

        productList.add(
                new ListData(
                        1,
                        "Bank BCA KCP A.Yani",
                        "Jl. Jend. A. Yani Km.2 No. 74, Sungai Baru, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70654",
                        R.drawable.bca));

        productList.add(
                new ListData(
                        1,
                        "Bank Kalsel Syariah Cabang Banjarmasin",
                        "Jl. Brigjend Hasan Basry No.8, Pangeran, Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70123",
                        R.drawable.bkalsal));

        productList.add(
                new ListData(
                        1,
                        "Bank BNI KLN Mayjend Sutoyo",
                        "Jl. Mayjen Sutoyo S, Tlk. Dalam, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70117",
                        R.drawable.bni));



        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override

            public void onFabClick(View v, int position) {
                if (position==0) {
                    bukapeta(-3.323326, 114.591870);
                } else if (position==1){
                    bukapeta(-3.324468, 114.602133);
                } else if (position==2) {
                    bukapeta(-3.308593, 114.588454);
                } else if (position==3) {
                    bukapeta(-3.322412, 114.575452);
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

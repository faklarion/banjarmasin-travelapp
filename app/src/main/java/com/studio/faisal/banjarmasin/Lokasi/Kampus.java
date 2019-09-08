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



public class Kampus extends AppCompatActivity {
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
        Intent i = new Intent(Kampus.this, MapsActivity.class);
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
        getSupportActionBar().setTitle("Kampus");
        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Universitas Lambung Mangkurat",
                        "Jl. Brigjen H. Hasan Basri, Pangeran, Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70123",
                        R.drawable.ulm));

        productList.add(
                new ListData(
                        1,
                        "Politeknik Negeri Banjarmassin",
                        "Jl. Brigjen H. Hasan Basri, Pangeran, Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70123",
                        R.drawable.politeknik));

        productList.add(
                new ListData(
                        1,
                        "Universitas Islam Kalimantan Muhammad Arsyad Al-Banjari",
                        "Jl. Adhyaksa, Jl. Kayu Tangi 1 Jalur 2 No.2, Sungai Miai, Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70123",
                        R.drawable.uniska));
        productList.add(
                new ListData(
                        1,
                        "Universitas Muhammadiyah Banjarmasin",
                        "Jalan S. Parman. Kompleks RS Islam, Pasar Lama, Banjarmasin Tengah, Ps. Lama, Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70114",
                        R.drawable.universitas_muhammadiyah));


        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override
            public void onFabClick(View v, int position) {
                if (position==0) {
                    bukapeta(-3.298688, 114.584731);
                } else if (position==1){
                    bukapeta(-3.295683, 114.581855);
                } else if (position==2) {
                   bukapeta(-3.289484, 114.594919);
                } else if (position==3) {
                    bukapeta(-3.307769, 114.590057);
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

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
public class Alam extends AppCompatActivity {
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
        Intent i = new Intent(Alam.this, MapsActivity.class);
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
        getSupportActionBar().setTitle("Wisata Alam");
        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ListData(
                        1,
                        "Pulau Kembang",
                        "Kecamatan Alalak, Kabupaten Barito Kuala, provinsi Kalimantan Selatan.",
                        R.drawable.pkembang));

        productList.add(
                new ListData(
                        1,
                        "Pulau Bakut",
                        "Jalan Trans Kalimantan, Marabahan Baru, Anjir Muara, Kabupaten Barito Kuala",
                        R.drawable.pbakut));

        productList.add(
                new ListData(
                        1,
                        "Wisata Rumah Sangkut Gunung Kupang",
                        "Jalan Gunung Kupang, Kecamatan Cempaka, Kota Banjarbaru",
                        R.drawable.rsangkut));

        productList.add(
                new ListData(
                        1,
                        "Agrowisata Kebun Durian (Meek Farm)",
                        "Jl. Guntung Manggis, Guntungmanggis, Landasan Ulin, Kota Banjar Baru",
                        R.drawable.kdurian));

        productList.add(
                new ListData(
                        1,
                        "Danau Seran",
                        "Jl. Guntung Manggis, Guntungmanggis, Landasan Ulin, Kota Banjar Baru",
                        R.drawable.dseran));

        //creating recyclerview adapter
        HotelAdapter adapter = new HotelAdapter(this, productList, new CustomItemClickListener() {
            @Override
            public void onFabClick(View v, int position) {
                if (position==0) {
                    bukapeta(-3.299644, 114.560736);
                } else if (position==1){
                    bukapeta(-3.215101, 114.557658);
                } else if (position==2) {
                    bukapeta(-3.473652, 114.859666);
                } else if (position==3) {
                    bukapeta(-3.467506, 114.792238);
                } else if (position==4) {
                    bukapeta(-3.489344, 114.791404);
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

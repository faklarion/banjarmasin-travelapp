package com.studio.faisal.banjarmasin;

/**
 * Created by Faisal on 20/01/2019.
        */
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.studio.faisal.banjarmasin.Lokasi.Alam;
import com.studio.faisal.banjarmasin.Lokasi.Bank;
import com.studio.faisal.banjarmasin.Lokasi.Hotel;
import com.studio.faisal.banjarmasin.Lokasi.Ibadah;
import com.studio.faisal.banjarmasin.Lokasi.Kampus;
import com.studio.faisal.banjarmasin.Lokasi.Perbelanjaan;
import com.studio.faisal.banjarmasin.Lokasi.Populer;
import com.studio.faisal.banjarmasin.Lokasi.RS;
import com.studio.faisal.banjarmasin.Lokasi.Resto;
import com.studio.faisal.banjarmasin.Lokasi.Terminal;

public class Tempat extends Fragment {
    ViewFlipper v_flipper;
    GridView androidGridView;

    String[] gridViewString = {
            "Hotel", "Tempat Ibadah", "Tempat Poluler", "ATM/Bank", "Wisata Alam", "Terminal Transportasi", "Rumah Sakit", "Restoran", "Pusat Belanja", "Kampus"
                } ;
    int[] gridViewImageId = {
            R.drawable.hotel, R.drawable.ibadah, R.drawable.populer, R.drawable.bank, R.drawable.alam, R.drawable.terminal, R.drawable.rs, R.drawable.resto, R.drawable.belanja, R.drawable.kampus,
                };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tempat, container, false);
        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4};

        v_flipper = (ViewFlipper) v.findViewById(R.id.v_flipper);

        for (int image1 : images) {
            fliverImages(image1);
        }
        for (int image: images)
            fliverImages(image);
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getActivity(), gridViewString, gridViewImageId);
        androidGridView=(GridView) v.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                if(position==0) {
                    Intent intent = new Intent(getActivity(), Hotel.class);
                    startActivity(intent);
                } else if (position==1){
                    Intent intent = new Intent(getActivity(), Ibadah.class);
                    startActivity(intent);
                } else if (position==2) {
                    Intent intent = new Intent(getActivity(), Populer.class);
                    startActivity(intent);
                } else if (position==3) {
                    Intent intent = new Intent(getActivity(), Bank.class);
                    startActivity(intent);
                } else if (position==4) {
                    Intent intent = new Intent(getActivity(), Alam.class);
                    startActivity(intent);
                } else if (position==5) {
                    Intent intent = new Intent(getActivity(), Terminal.class);
                    startActivity(intent);
                } else if (position==6) {
                    Intent intent = new Intent(getActivity(), RS.class);
                    startActivity(intent);
                } else if (position==7) {
                    Intent intent = new Intent(getActivity(), Resto.class);
                    startActivity(intent);
                } else if (position==8) {
                    Intent intent = new Intent(getActivity(), Perbelanjaan.class);
                    startActivity(intent);
                } else if (position==9) {
                    Intent intent = new Intent(getActivity(), Kampus.class);
                    startActivity(intent);
                }


            }
        });
        return v;
    }
    public  void  fliverImages(int images){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);

    }
}

package com.studio.faisal.banjarmasin;

/**
 * Created by Faisal on 20/01/2019.
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Tentang extends Fragment{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tentang, container, false);
        MobileAds.initialize(getActivity(), "ca-app-pub-1330999924595324~3145764942");
        AdView adBannar = (AdView) view.findViewById(R.id.adBanner);
        final AdRequest adRequest =new AdRequest.Builder().build();
        adBannar.loadAd(adRequest);
        adBannar.setAdListener(new AdListener(){
            @Override
            public void onAdFailedToLoad(int i) {

            }
        });
        return view;
    }
}

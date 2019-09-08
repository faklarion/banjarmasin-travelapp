package com.studio.faisal.banjarmasin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Nomer extends AppCompatActivity {
    ListView lvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomer);
        lvResult = (ListView) findViewById(R.id.lvResult);


        String[][] dataNomer = new String[][]{{"Poltabes Banjarmasin", "05113251411", "ic_call_black_24dp"}, {"RSUD Daerah Ulin Bajarmasin", "05113257472", "ic_call_black_24dp"}, {"PMKHIPPINDO", "05117500911", "ic_call_black_24dp"}, {"PLN", "0511123", "ic_call_black_24dp"}, {"PDAM Bandarmasih", "05113252541", "ic_call_black_24dp"}};

        NomerAdapter adapter = new NomerAdapter(Nomer.this, dataNomer);
        lvResult.setAdapter(adapter);
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + "05113251411"));
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + "05113257472"));
                    startActivity(intent);
                }

                if (position == 2) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + "05117500911"));
                    startActivity(intent);
                }

                if (position == 3) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + "0511123"));
                    startActivity(intent);
                }

                if (position == 4) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + "05113252541"));
                    startActivity(intent);
                }

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

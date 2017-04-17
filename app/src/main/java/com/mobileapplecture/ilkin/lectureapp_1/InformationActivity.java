package com.mobileapplecture.ilkin.lectureapp_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Bundle extras = getIntent().getExtras();

        TextView txt_name = (TextView) findViewById(R.id.txt_adSoyad);
        Button btn_showList = (Button) findViewById(R.id.btn_showList);
        Button btn_ayarlar = (Button) findViewById(R.id.btn_ayarlar);

        Button city_button = (Button) findViewById(R.id.btn_cityList);
        Log.e("Button", "information activity");


        city_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InformationActivity.this, CityListActivity.class);
                startActivity(i);
            }
        });
        txt_name.setText("Merhaba\n" + extras.getString("key_name") + " " + extras.getString("key_surname") + "!");
        btn_showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent listIntent = new Intent(InformationActivity.this, ListActivity.class);
                startActivity(listIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btn_ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ayarlarIntent = new Intent(InformationActivity.this, Ayarlar.class);
                startActivity(ayarlarIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}

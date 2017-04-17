package com.mobileapplecture.ilkin.lectureapp_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
* Dersde gosterilen array Adapter ornegi
*
* */

public class CityListActivity extends AppCompatActivity {

    private String[] cities = {"Baku", "Istanbul", "Barcelona"} ;// data source

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        ListView myList = (ListView) findViewById(R.id.list_cities);
        // context  	hazir bir layout 				item`lar		 data source
//        ArrayAdapter myAdapter = new ArrayAdapter (this, android.R.layout.simple_list_item_1, cities);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,cities);
        // Layout tarafindaki list ile adapter`i iliskilendirmek
        myList.setAdapter(myAdapter);

        // listener liste uzerinde hangi item`i secip, action alacagimizi secer

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            // 											tiklanan view   onun pozisyonu ve id`i
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                // pop-up dialog box
                AlertDialog.Builder myDialog = new AlertDialog.Builder(CityListActivity.this);

                //				secilen item`in pozisyonu
                myDialog.setMessage(cities[position]);

                // cancel butonu yok
                myDialog.setCancelable(false);

                // positive buton tanimlandi, tamam olarak isimlendi
                myDialog.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                // ekranda gozukmesi icin dialog olusturuldu ve gosterildi
                myDialog.create().show();
            }
        });


    }
}

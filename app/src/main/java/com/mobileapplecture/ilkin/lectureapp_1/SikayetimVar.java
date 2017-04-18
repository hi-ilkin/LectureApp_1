package com.mobileapplecture.ilkin.lectureapp_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SikayetimVar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EditText std_name = (EditText) findViewById(R.id.txt_adSoyad);
        EditText std_ID = (EditText) findViewById(R.id.txt_stdID);
        EditText sk_subject = (EditText) findViewById(R.id.txt_sikayet_subject);
        EditText sk_body = (EditText) findViewById(R.id.txt_sikayet_body);

        Button btn_submitSk = (Button) findViewById(R.id.btn_submitSikayet);


        btn_submitSk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        setContentView(R.layout.activity_sikayetim_var);
    }
}

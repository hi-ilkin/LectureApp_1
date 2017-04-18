package com.mobileapplecture.ilkin.lectureapp_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SikayetimVar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sikayetim_var);


        final EditText txt_std_name = (EditText) findViewById(R.id.txt_adSoyad);
        final EditText txt_std_ID = (EditText) findViewById(R.id.txt_stdID);
        final EditText txt_sk_subject = (EditText) findViewById(R.id.txt_sikayet_subject);
        final EditText txt_sk_body = (EditText) findViewById(R.id.txt_sikayet_body);

        Button btn_submitSk = (Button) findViewById(R.id.btn_submitSikayet);

        final DBHelper mDbHelper = new DBHelper(getApplicationContext());


        btn_submitSk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Gets the data repository in write mode
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(FeedReaderIssues.FeedEntry.COLUMN_STD_ID, Integer.parseInt(String.valueOf(txt_std_ID.getText())));
                values.put(FeedReaderIssues.FeedEntry.COLUMN_STD_NAME_SURNAME, String.valueOf(txt_std_name.getText()));
                values.put(FeedReaderIssues.FeedEntry.COLUMN_ISSUE_SUBJECT, String.valueOf(txt_sk_subject.getText()));
                values.put(FeedReaderIssues.FeedEntry.COLUMN_ISSUE_BODY, String.valueOf(txt_sk_body.getText()));

// Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(FeedReaderIssues.FeedEntry.TABLE_NAME, null, values);
                Log.e("DB", String.valueOf(newRowId));
            }
        });
    }
}

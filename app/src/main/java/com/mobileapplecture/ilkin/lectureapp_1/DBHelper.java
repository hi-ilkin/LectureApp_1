package com.mobileapplecture.ilkin.lectureapp_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ilkin on 18-Apr-17.
 */



public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME   = "USER_RESPONSES";
    private static final String TABLE_ISSUES = "issues";

    private static final String SQL_CREATE_ENTRIES = "Create Table " + TABLE_ISSUES ;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("sdfsf");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

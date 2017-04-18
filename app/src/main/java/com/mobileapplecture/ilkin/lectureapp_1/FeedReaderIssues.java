package com.mobileapplecture.ilkin.lectureapp_1;

import android.provider.BaseColumns;

/**
 * Created by Ilkin on 18-Apr-17.
 *
 * Schema class for our Database
 */

public class FeedReaderIssues {

/*
*     // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

     Inner class that defines the table contents
public static class FeedEntry implements BaseColumns {
    public static final String TABLE_NAME = "entry";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_SUBTITLE = "subtitle";
}
*/
// To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderIssues(){}

    /*Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns{

        public static final String TABLE_NAME = "issues";
        public static final String COLUMN_STD_NAME_SURNAME = "name_surname";
        public static final String COLUMN_STD_ID = "std_id";
        public static final String COLUMN_ISSUE_SUBJECT = "issue_subject";
        public static final String COLUMN_ISSUE_BODY = "issue_body";


        public static final String SQL_CREATE_ENTRIES = "Create Table " + FeedEntry.TABLE_NAME +
                                                            FeedEntry._ID + " INTEGER PRIMARY KEY," +
                                                            FeedEntry.COLUMN_STD_ID + " INTEGER," +
                                                            FeedEntry.COLUMN_STD_NAME_SURNAME + " TEXT," +
                                                            FeedEntry.COLUMN_ISSUE_SUBJECT + " TEXT," +
                                                            FeedEntry.COLUMN_ISSUE_BODY + "TEXT";


        public static final String SQL_DELETE_ENTRIES = "Drop table if exist "+ FeedEntry.TABLE_NAME;
    }


}

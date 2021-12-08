package com.example.alarmpractice;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AlarmDatabase {
    private static final String TAG = "AlarmDatabase";
    private static AlarmDatabase database;

    /**
     * table name for MEMO
     */
    public static String TABLE_NOTE = "NOTE";

    /**
     * version
     */
    public static int DATABASE_VERSION = 1;


}

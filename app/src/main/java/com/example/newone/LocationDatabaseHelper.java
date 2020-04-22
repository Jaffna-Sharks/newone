package com.example.newone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocationDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "location.db";
    public static final String TABLE_NAME = "location_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "CITY";
    public static final String COL_2 = "STREET";
    public static final String COL_3 = "DISTRICT";
    public static final String COL_4 = "PROVINCE";



    public LocationDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , CITY TEXT , STREET TEXT , DISTRICT TEXT , PROVINCE TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
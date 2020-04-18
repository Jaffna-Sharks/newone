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


    public boolean insertData(String city , String street , String district , String province ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,city);
        contentValues.put(COL_2,street);
        contentValues.put(COL_3,district);
        contentValues.put(COL_4,province);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }
    public Integer DeleteData(String city){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, " CITY  = ? ", new String[]{ city });


    }
    public boolean updateData(String city , String street , String district , String province  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,city);
        contentValues.put(COL_2,street);
        contentValues.put(COL_3,district);
        contentValues.put(COL_4,province);

        db.update(TABLE_NAME, contentValues, " CITY = ?" ,new String[]{ city });
        return true;

    }
    public Cursor search(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" WHERE CITY='"+value+"'",null);
        return res;


    }


    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return  data;
    }


}

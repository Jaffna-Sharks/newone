package com.example.newone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class parkingDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "parking.db";
    public static final String TABLE_NAME = "parking_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "VEHICLENO";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "COMPANY";
    public static final String COL_4 = "CARCOLOUR";
    public static final String COL_5 = "HOURS";
    public static final String COL_6 = "SLOT";




    public parkingDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , VEHICLENO INTEGER , EMAIL TEXT , COMPANY TEXT , CARCOLOUR TEXT , HOURS INTEGER , SLOT INTEGER  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String vechileno , String email , String company , String carcolour, String hours ,String slot ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,vechileno);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,company);
        contentValues.put(COL_4,carcolour);
        contentValues.put(COL_5,hours);
        contentValues.put(COL_6,slot);

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
    public Integer DeleteData(String vechlieno){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, " VEHICLENO  = ? ", new String[]{ vechlieno });


    }
    public boolean updateData(String vechileno , String email , String company , String carcolour, String hours ,String slot ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,vechileno);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,company);
        contentValues.put(COL_4,carcolour);
        contentValues.put(COL_5,hours);
        contentValues.put(COL_6,slot);

        db.update(TABLE_NAME, contentValues, " VEHICLENO = ?" ,new String[]{ vechileno });
        return true;

    }
    public Cursor search(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" WHERE VEHICLENO='"+value+"'",null);
        return res;


    }


    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return  data;
    }


}

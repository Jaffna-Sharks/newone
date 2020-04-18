package com.example.newone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PaymentDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "payment.db";
    public static final String TABLE_NAME = "payment_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "VECHILENO";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "HOURS";
    public static final String COL_4 = "AMOUNT";
    public static final String COL_5 = "PAYMENT";



    public PaymentDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , VECHILENO TEXT , NAME TEXT , HOURS TEXT , AMOUNT TEXT ,PAYMENT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String vechlieno , String name , String hours , String amount,String payment ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,vechlieno);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,hours);
        contentValues.put(COL_4,amount);
        contentValues.put(COL_5,payment);

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
        return db.delete(TABLE_NAME, " VECHILENO  = ? ", new String[]{ vechlieno });


    }
    public boolean updateData(String vechlieno , String name , String hours , String amount,String payment ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,vechlieno);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,hours);
        contentValues.put(COL_4,amount);
        contentValues.put(COL_5,payment);
        db.update(TABLE_NAME, contentValues, " VECHILENO = ?" ,new String[]{ vechlieno });
        return true;

    }
    public Cursor search(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" WHERE VECHILENO='"+value+"'",null);
        return res;


    }


    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return  data;
    }


}

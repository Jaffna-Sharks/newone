package com.example.newone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "event.db";
    public static final String TABLE_NAME = "event_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "CARDNO";
    public static final String COL_2 = "EXP";
    public static final String COL_3 = "CVC";
    public static final String COL_4 = "NAME";



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , CARDNO INTEGER , EXP INTEGER , CVC INTEGER , NAME TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String cardno , String exp , String cvc , String name ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,cardno);
        contentValues.put(COL_2,exp);
        contentValues.put(COL_3,cvc);
        contentValues.put(COL_4,name);

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
    public Integer DeleteData(String cardno){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, " CARDNO  = ? ", new String[]{ cardno });


    }
    public boolean updateData(String cardno , String exp , String cvc , String name ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,cardno);
        contentValues.put(COL_2,exp);
        contentValues.put(COL_3,cvc);
        contentValues.put(COL_4,name);

        db.update(TABLE_NAME, contentValues, " CARDNO = ?" ,new String[]{ cardno });
        return true;

    }
    public Cursor search(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" WHERE CARDNO='"+value+"'",null);
        return res;


    }


    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return  data;
    }


}

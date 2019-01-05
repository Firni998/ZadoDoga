package com.example.firni.zado;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Adatbazis extends SQLiteOpenHelper{


    public static final String DATABASE_NAME = "regisztracio.db";

    public static final String TABLE_NAME = "felhaszalok";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "felhasznalo";
    public static final String COL_3 = "jelszo";


    public Adatbazis(Context context){
        super(context,DATABASE_NAME,null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + TABLE_NAME + " " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, felhasznalo text UNIQUE," +
                "jelszo text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
    }
    public boolean beolvas(String felhasznalo,String jelszo){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,felhasznalo);
        contentValues.put(COL_3,jelszo);

        long beolvasas = db.insert(TABLE_NAME, null,contentValues);

        if(beolvasas == -1)
            {
                return false;
            }
        else
            {
                return true;
            }
        }
        public boolean ellenorzes(String felhasznalo){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from felhasznalok where felhasznalo=?", new String []{felhasznalo});

        if(cursor.getCount()>0)
        {
            return false;
        }
        else
            {
            return true;
            }
        }

        public boolean felhasznaloesjelszo(String felhasznalo,String jelszo){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from felhasznalok where felhasznalo=? and jelszo=?", new String[]{felhasznalo,jelszo});
        if(cursor.getCount()>0)
        {
            return false;
        }
        else
            {
            return true;
            }
        }




}

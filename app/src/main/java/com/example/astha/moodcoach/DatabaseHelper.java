package com.example.astha.moodcoach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="User.db";
    public static final String Table_Name="User_table";
    public static final String Col_1 ="ID";
    public static final String Col_2 ="INPUT";

    public static final String Database_Name1="Register.db";
    public static final String Table_Name1="Register_table";
    public static final String Col_first ="ID";
    public static final String Col_second ="Fullname";
    public static final String Col_third ="Email";
    public static final String Col_fourth ="Password";


    public DatabaseHelper(Context context) {
        super(context, Database_Name1, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FullName TEXT,Email TEXT, Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);

        onCreate(db);
    }

    public boolean insertData(String input)
    {  SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_2,input);
        long result=db.insert(Table_Name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+Table_Name,null);
        return res;
    }

}

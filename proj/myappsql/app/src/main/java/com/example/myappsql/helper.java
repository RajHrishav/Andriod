package com.example.myappsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class helper extends SQLiteOpenHelper
{

    public helper(Context context)
    {
        super(context, "Studdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table student(Sroll text,Sname text,Smarks text)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL("drop table if exists student");
        onCreate(db);
    }
}

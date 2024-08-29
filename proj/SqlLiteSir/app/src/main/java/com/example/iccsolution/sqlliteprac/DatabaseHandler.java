package com.example.iccsolution.sqlliteprac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "StudentDatabase";

    public DatabaseHandler(Context context) {
        //creating Database
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//Creating Table
        String sql = "CREATE TABLE students " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstname TEXT, " +
                "email TEXT ) ";
        //upar wale line me primary key use kiye h, to avoid duplication.

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS students";
        db.execSQL(sql);

        onCreate(db);
    }
}


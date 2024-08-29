package com.example.myappsql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper obj = new helper(this);

       /* SQLiteDatabase db =  obj.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Sroll","01");   
        values.put("Sname","Hrishav");
        values.put("Smarks","40");

        values.put("Sroll","02");
        values.put("Sname","Aman");
        values.put("Smarks","65");

       long row =  db.insert("student",null,values);
       System.out.print("last row ="+row);*/

       SQLiteDatabase db = obj.getReadableDatabase();
       String projection[] = {"Sroll","Sname","Smarks"};
       Cursor c = db.query("student",projection,null,null,null,null,null);

        c.moveToPosition(1);//to get data from 1st row
        System.out.println("name is"+c.getString(1));//to fetch data of 1st column







    }
}

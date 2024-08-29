package com.example.iccsolution.listviewprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Create my Array DataSource for the listView Item
String[] myfreinds={"Anubhav","Mahinder","Sonu","Rahul","Anit","Raju","Arnab","Anubhav","Mahinder","Sonu","Rahul","Anit","Raju","Arnab"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create the object of the ArrayAdapter Class
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
              	R.layout.item_layout, myfreinds);
        //get the Reference of the ListView
        	ListView listView = (ListView) findViewById(R.id.listview1);
        	//adding the adapter to listview
        listView.setAdapter(adapter);


    }
}

package com.example.myapplicationlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    String[] myfrineds ={"frndA","frndB","frndC","frndA","frndB","frndC","frndA","frndB","frndC","frndA","frndB","frndC","frndA","frndB","frndC","frndA","frndB","frndC","frndA","frndB","frndC","frndA","frndB","frndC"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.item,myfrineds);
        ListView listView = (ListView)findViewById(R.id.lstview);
        listView.setAdapter(adapter);

    }
}

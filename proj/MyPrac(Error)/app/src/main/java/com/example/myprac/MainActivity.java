package com.example.myprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    ListView lv;
    public static Integer [] imgARR =
            {
                    R.drawable.b, R.drawable.b, R.drawable.b,
                    R.drawable.b, R.drawable.b, R.drawable.b,
                    R.drawable.b, R.drawable.b, R.drawable.b,
                    R.drawable.b, R.drawable.b, R.drawable.b

            };

    public static String [] sourceARR = {"00","00","00","00","00","00","00","00","00","00","00","00","00","00"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv =(ListView)findViewById(R.id.lst);


       // ArrayAdapter obj =new ArrayAdapter<String>(getApplicationContext(),R.layout.item,Arrays.asList(source));

        MyAdapter obj = new MyAdapter(this,imgARR,sourceARR);

        lv.setAdapter(obj);




    }

}

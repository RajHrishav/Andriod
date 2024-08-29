package com.example.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    Intent i =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // i = new Intent(getApplicationContext(), MyService.class);
    }

    public void start(View view)
    {
            i =new Intent(getApplicationContext(),MyService.class);
            startService(i);
    }

    public void stop(View view)
        {
            i =new Intent(getApplicationContext(),MyService.class);
            stopService(i);//service is stopped from intent.
        }

}

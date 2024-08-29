package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service
{

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }


    public void onCreate()
    {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"Service Created",Toast.LENGTH_SHORT).show();
        Log.d("MyService","service created");
    }

    public int onStartCommand(Intent intent,int flags,int startId)
    {
        Log.d("MyService","service Created");
        //stopService(); service is stopped on it own
        Toast.makeText(getApplicationContext(),"service Started",Toast.LENGTH_SHORT).show();
        return super.onStartCommand( intent,flags, startId);

    }

    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "service Destroyed", Toast.LENGTH_SHORT).show();
        Log.d("MyService","service Destroyed");
        return;
    }

}

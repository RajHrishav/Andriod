package com.pckg.locntracking;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
{
        Button btnShowLocation;
       private static final int request_code_permission = 2;
       String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

       GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            if(ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION)!=
                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission((getApplicationContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION !=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(thuis,new String[]{mPermission},REQUEST_CODE_PERMISSION);
            }


        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        btnShowLocation = (Button)findViewById(R.id.button);

    }

    public void btnMethod(View view)
    {
        gps = new GPSTracker(MainActivity.this);
        if(gps.canGetLocation()) {
            double longitude = gps.getLatitude();
            double latitude = gps.getLongitude();


            Toast.makeText(getApplicationContext(),
                    "your loc is LATITUDE=" + latitude + "LONGITUDE=" + longitude, Toast.LENGTH_SHORT).show();
        }

        else
            {
                gps.showSettingAlerts();
            }
    }
}

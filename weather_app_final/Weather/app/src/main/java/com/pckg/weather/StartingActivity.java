package com.pckg.weather;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartingActivity extends Activity
{
    EditText et1;
    Button b1;
    Button btnFetchLocation;
    double longitude=0.0,latitude=0.0;

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPSTracker gps;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

       // et1.setText("");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        et1=(EditText)findViewById(R.id.editText);

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will
                // execute every time, else your else part will work
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        btnFetchLocation = (Button) findViewById(R.id.buttonGps);

    }

    public void goToSecondActivity(View view)
    {
       Intent intent = new Intent(StartingActivity.this,WeatherActivity.class);

        intent.putExtra("_key",et1.getText().toString().trim());
        //setting temporary value of latitude and longitude
        latitude =22.57 ;
        longitude=88.35;
        intent.putExtra("_lat",latitude);
        intent.putExtra("_lon",longitude);
        startActivity(intent);

    }

    public void useGps(View view) {
        gps = new GPSTracker(StartingActivity.this);

        // check if GPS enabled
        if(gps.canGetLocation()) {

            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
        }
        else
        {
            // can't get location// GPS or Network is not enabled// Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

        Intent intent = new Intent(StartingActivity.this, WeatherActivity.class);

        intent.putExtra("_key", "");
        intent.putExtra("_lat", latitude);
        intent.putExtra("_lon", longitude);

        startActivity(intent);



    }
}

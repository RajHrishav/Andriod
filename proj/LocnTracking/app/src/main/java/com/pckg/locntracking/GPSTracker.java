package com.pckg.locntracking;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Network;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class GPSTracker extends Service implements LocationListener

{

    private final Context mContext;

    boolean isGPSenabled =false;

    boolean canGetLocation = false;
    boolean isNetworkenabled = false;

    Location location;
    double latitude,longitude;

    private static final long MIN_DISTANCE_CHANGE_FROM_UPDATE=10;

    private static final long MIN_TIME_BW_UPDATE=10;
    protected LocationManager locationManager;
        public GPSTracker()
        {
            this.mContext= context;

        super();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    private Location getLocation()
    {
        try
        {
            locationManager = (LocationManager)mContext.getSystemService(LOCATION_SERVICE);
            isNetworkenabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if(!isGPSenabled && !isNetworkenabled)
            {

            }

            else
                {
                    this.canGetLocation =true;
                    if(isNetworkenabled)
                    {
                        locationManager.requestLocationUpdates
                                (LocationManager.NETWORK_PROVIDER,
                                        MIN_TIME_BW_UPDATE,
                                        MIN_DISTANCE_CHANGE_FROM_UPDATE,this);
                        Log.d("Network",Network);

                        if(locationManager!=null)
                        {
                            location =locationManager
                                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                            if(location!=null)
                            {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();

                            }
                        }


                    }
                }

                if(isGPSenabled)
                {
                    if(location==null)
                    {

                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATE,
                                MIN_DISTANCE_CHANGE_FROM_UPDATE,this);

                        Log.d("GPS Enabled","GPS Enabled");if(locationManager!=null);

                        if(locationManager!=null)

                        {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);


                        if(location!=null)
                        {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();

                        }
                    }
                    }
                }
        }

    }
}


public void stopUsingGps()
{

}


public void showSettingAlerts()
{
    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

    alertDialog.setTitle("GPS is setting");
    alertDialog.setMessage("GPS is not enabled YOU have to go to setting MENU");
    alertDialog.setPositiveButton("setting", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            mContext.

        }
    })




}

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
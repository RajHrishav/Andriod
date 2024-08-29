package com.pckg.weather;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class WeatherActivity extends AppCompatActivity
{
    private String TAG = WeatherActivity.class.getSimpleName();
     private ProgressDialog pDialog;
     Button bLoc,bForecast;
     ImageButton bowm;
     private TextView tempereture, condition, loacation,mintemp,maxtemp,humidity,date;
     private ImageView weathericon;
     //ListView lv;
     Context context;

    String Location, Description, IconId, IconUrl;
    String Date;
    Double Temperature,MinTemp,MaxTemp ;

    int Humidity ;
    private String url, jsonStr;
    long CityID;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Intent intent = getIntent();
        String place = intent.getStringExtra("_key");
        Double lat=intent.getDoubleExtra("_lat",0.0);
        Double lon=intent.getDoubleExtra("_lon",0.0);
        String urlMid =null;

        boolean fl = place.equals("");

        if(fl)
        {
            urlMid="lat="+lat+"&lon="+lon;
        }
        else
        {
            urlMid="q="+place;
        }

        //url = "http://api.openweathermap.org/data/2.5/weather?"+urlMid+"&units=metric&APPID=415be0f670555e0ee0a73cf94cd895d4";
        url ="http://api.openweathermap.org/data/2.5/forecast?"+urlMid+"&units=metric&APPID=415be0f670555e0ee0a73cf94cd895d4";
        bLoc = (Button)findViewById(R.id.buttonChngLoc);
        bForecast=(Button)findViewById(R.id.btnForecast);
        bowm=(ImageButton)findViewById(R.id.btnOwm);
        weathericon = (ImageView) findViewById(R.id.imgIcon);
        tempereture = (TextView) findViewById(R.id.txtTemp);
        condition = (TextView) findViewById(R.id.txtCond);
        loacation = (TextView) findViewById(R.id.txtLocn);
        mintemp = (TextView) findViewById(R.id.txtMIn);
        maxtemp = (TextView) findViewById(R.id.txtMax);
        humidity= (TextView) findViewById(R.id.txtHumidity);
        date =(TextView)findViewById(R.id.txtdate);

        new GetContacts().execute();

    }




    public class GetContacts extends AsyncTask<Void, Void, Void>
    {

        @Override
        public  void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(WeatherActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        public Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    /*JSONObject jsonObj = new JSONObject(jsonStr);
                    CodCheck = jsonObj.getString("cod");
                    if(CodCheck.equals("404"))
                    {
                        ;
                    }
                    else{}
                    // Getting JSON Array node
                    JSONArray Weather = jsonObj.getJSONArray("weather");//chuki contact ek array h niche
                    JSONObject Main = jsonObj.getJSONObject("main");
                    Location = jsonObj.getString("name");

                    Log.e(TAG, Location);
                    JSONObject w = Weather.getJSONObject(0);
                    Description = w.getString("description");
                    IconId = w.getString("icon");
                    IconUrl = "http://openweathermap.org/img/w/" + IconId + ".png";*/

                    JSONObject jsonobj =new JSONObject(jsonStr);
                    JSONObject City = jsonobj.getJSONObject("city");
                    Location = City.getString("name");
                    CityID = City.getLong("id");

                    JSONArray Arr = jsonobj.getJSONArray("list");
                    JSONObject obj = Arr.getJSONObject(1);
                    Date = obj.getString("dt_txt");

                    JSONObject Main =obj.getJSONObject("main");
                    Temperature = Main.getDouble("temp");

                    MinTemp = Main.getDouble("temp_min");
                    MaxTemp =Main.getDouble("temp_max") ;
                    Humidity =Main.getInt("humidity") ;

                    JSONArray Weather =obj.getJSONArray("weather");
                    JSONObject wObj= Weather.getJSONObject(0);
                    Description = wObj.getString("description");
                    IconId = wObj.getString("icon");
                    IconUrl = "http://openweathermap.org/img/w/" + IconId + ".png";



                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }

            }
            else {

                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
       public void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            tempereture.setText("TEMP"+"\n"+Double.toString(Temperature)+"°C");
            mintemp.setText("Min Temp="+Double.toString(MinTemp)+"°C");
            maxtemp.setText("Max Temp="+Double.toString(MaxTemp)+"°C");
            humidity.setText("Humidity="+Double.toString(Humidity)+"°C");
            condition.setText(Description);
            loacation.setText(Location);
            date.setText(Date);
            Picasso.get().load(IconUrl).into(weathericon);

        }

    }

    public void GO_to_Owm(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://openweathermap.org/city/"+CityID));
        startActivity(intent);

    }

    public void goToSecondLastActivity(View view)
    {
        Intent intentGoToSecondLast = new Intent(WeatherActivity.this,SecondLastActivity.class);
        intentGoToSecondLast.putExtra("STR",jsonStr);
        startActivity(intentGoToSecondLast);
    }


    public void goToPrevActivity(View view)
    {
        Intent intentPrev = new Intent(WeatherActivity.this,StartingActivity.class);
        startActivity(intentPrev);
    }


}

package com.pckg.weather;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LastActivity extends AppCompatActivity {
    private String TAG = WeatherActivity.class.getSimpleName();
    int day;
    ProgressDialog pDialog;
    //ListView lv;
    Context context;
    String Location, Description, Date, IconId, IconUrl;
    Double Temperature, MinTemp, MaxTemp;
    int Humidity;
    String jsonStr = null;
    long CityID;

    TextView TEMP, MINTEMP, MAXTEMP, HUMIDITY, DESCRIPTION, PLACE, DATE;
    ImageView IMGICON;
    String url, urlMid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        Bundle bl = getIntent().getExtras();
        day = bl.getInt("DAY");
        urlMid = bl.getString("pl");
        jsonStr = bl.getString("JSONSTR");


        url = "http://api.openweathermap.org/data/2.5/forecast?" + urlMid + "&units=metric&APPID=415be0f670555e0ee0a73cf94cd895d4";

        TEMP = (TextView) findViewById(R.id.txtTemp);
        MINTEMP = (TextView) findViewById(R.id.txtMinTemp);
        MAXTEMP = (TextView) findViewById(R.id.txtMaxTemp);
        HUMIDITY = (TextView) findViewById(R.id.txtHumidity);
        DESCRIPTION = (TextView) findViewById(R.id.txtDescription);
        PLACE = (TextView) findViewById(R.id.txtPlace);
        DATE = (TextView) findViewById(R.id.txtDate);
        IMGICON = (ImageView) findViewById(R.id.imgIcon);


        if (jsonStr != null) {
            try {

                JSONObject jsonobj = new JSONObject(jsonStr);
                JSONObject City = jsonobj.getJSONObject("city");
                Location = City.getString("name");
                CityID = City.getLong("id");

                JSONArray Arr = jsonobj.getJSONArray("list");
                JSONObject obj = Arr.getJSONObject(8*(day-1)+1);
                Date = obj.getString("dt_txt");

                JSONObject Main = obj.getJSONObject("main");
                Temperature = Main.getDouble("temp");

                MinTemp = Main.getDouble("temp_min");
                MaxTemp = Main.getDouble("temp_max");
                Humidity = Main.getInt("humidity");

                JSONArray Weather = obj.getJSONArray("weather");
                JSONObject wObj = Weather.getJSONObject(0);
                Description = wObj.getString("description");
                IconId = wObj.getString("icon");
                IconUrl = "http://openweathermap.org/img/w/" + IconId + ".png";

                TEMP.setText("TEMP"+"\n"+Double.toString(Temperature)+"°C");
                MINTEMP.setText("Min Temp"+"\n" + Double.toString(MinTemp)+"°C");
                MAXTEMP.setText("Max Temp" +"\n"+ Double.toString(MaxTemp)+"°C");
                HUMIDITY.setText("Humidity=" + Double.toString(Humidity));
                DESCRIPTION.setText(Description);
                PLACE.setText(Location+" "+Date);
                Picasso.get().load(IconUrl).into(IMGICON);


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


    }
}


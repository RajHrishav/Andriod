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

public class LastActivity extends AppCompatActivity
{
    private String TAG = WeatherActivity.class.getSimpleName();
    int day;
    ProgressDialog pDialog;
    //ListView lv;
    Context context;
    String Location, Description,Date,IconId, IconUrl;
    Double Temperature,MinTemp,MaxTemp ;
    int Humidity ;
    String  jsonStr;

    TextView TEMP,MINTEMP,MAXTEMP,HUMIDITY,DESCRIPTION,PLACE,DATE;
    ImageView IMGICON;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Intent intent_= getIntent();
        jsonStr=intent_.getStringExtra("str");
        day =intent_.getIntExtra("DAY",0);
       // lv = (ListView)findViewById(R.id.lst);
        TEMP = (TextView)findViewById(R.id.txtTemp);
        MINTEMP = (TextView)findViewById(R.id.txtMIn);
        MAXTEMP = (TextView)findViewById(R.id.txtMax);
        HUMIDITY = (TextView)findViewById(R.id.txtHumidity);
        DESCRIPTION = (TextView)findViewById(R.id.txtDescription);
        PLACE= (TextView)findViewById(R.id.txtPlace);
        DATE= (TextView)findViewById(R.id.txtDate);
        IMGICON =(ImageView)findViewById(R.id.imgIcon);

        new GetContacts().execute();
    }

    public class GetContacts extends AsyncTask<Void, Void, Void>
    {



        @Override
        public  void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getApplicationContext());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        public Void doInBackground(Void... arg0)
        {

            if (jsonStr != null) try {
                JSONObject jsonobj = new JSONObject("jsonStr");
                JSONObject City = jsonobj.getJSONObject("city");
                Location = City.getString("name");

                JSONArray Arr = jsonobj.getJSONArray("list");


                JSONObject obj = Arr.getJSONObject((day-1)*8);/////////////////////
                Date = obj.getString("dt_txt");/////////////////////

                JSONObject Main = obj.getJSONObject("main");
                Temperature = Main.getDouble("temp");
                MinTemp = Main.getDouble("temp_min");
                MaxTemp = Main.getDouble("temp_max");
                Humidity = Main.getInt("humidity");

                JSONArray Weather = obj.getJSONArray("weather");
                JSONObject wObj = Weather.getJSONObject(0);//ye index fixed rhega kyuki Weather array me keval ek obj h.
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
            TEMP.setText(Double.toString(Temperature));
            MINTEMP.setText("Min Temp="+Double.toString(MinTemp));
            MAXTEMP.setText("Max Temp="+Double.toString(MaxTemp));
            HUMIDITY.setText("Humidity="+Double.toString(Humidity));
            DESCRIPTION.setText(Description);
            PLACE.setText(Location);
            DATE.setText(Date);
            Picasso.get().load(IconUrl).into(IMGICON);

            /* Myadpater adapter = new Myadpater(LastActivity.this);
            lv.setAdapter(adapter);*/


        }

    }

}


package com.pckg.weather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondLastActivity extends AppCompatActivity
{
    ImageButton bt1,bt2,bt3,bt4,bt5;

    private String TAG = WeatherActivity.class.getSimpleName();

    String jsonStr;
    Intent intnt;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_last);



        bt1 =(ImageButton)findViewById(R.id.img1);
        bt2 =(ImageButton)findViewById(R.id.img2);
        bt3 =(ImageButton)findViewById(R.id.img3);
        bt4 =(ImageButton)findViewById(R.id.img4);
        bt5 =(ImageButton)findViewById(R.id.img5);

        Intent intentGoToSecondLast =getIntent();
        jsonStr = intentGoToSecondLast.getStringExtra("STR");


    }

    public void goToDay1(View view)
    {
        intnt = new Intent(SecondLastActivity.this,WeatherActivity.class);
        startActivity(intnt);
    }

    public void goToDay2(View view)
    {
        String jsonStr = this.jsonStr;
        intnt= new Intent(SecondLastActivity.this,LastActivity.class);
        intnt.putExtra("str",jsonStr);
        intnt.putExtra("DAY",2);
        startActivity(intnt);
        /*GetContacts obj = new GetContacts();
        obj.setDay(2);
        obj.execute();*/
    }

    public void goToDay3(View view)
    {
        String jsonStr = this.jsonStr;
        intnt= new Intent(SecondLastActivity.this,LastActivity.class);
        intnt.putExtra("str",jsonStr);
        intnt.putExtra("DAY",3);
        startActivity(intnt);

    }

    public void goToDay4(View view)
    {
        String jsonStr = this.jsonStr;
        intnt = new Intent(SecondLastActivity.this,LastActivity.class);
        intnt.putExtra("str",jsonStr);
        intnt.putExtra("DAY",4);
        startActivity(intnt);
    }

    public void goToDay5(View view)
    {
        String jsonStr = this.jsonStr;
        intnt = new Intent(SecondLastActivity.this,LastActivity.class);
        intnt.putExtra("str",jsonStr);
        intnt.putExtra("DAY",2);
        startActivity(intnt);
    }


}

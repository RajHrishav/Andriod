package com.example.iccsolution.myapplication8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get a reference to the recyclerView
        ListView mListView = (ListView) findViewById(R.id.listView);
        // 2. Create an adapter
        final FriendsAdapter friendsAdapter = new FriendsAdapter(this, setFriends());
        final CustomAdapter customadapter=new CustomAdapter(this,setFriendsandMobile());
        // 3. Set the adapter
        mListView.setAdapter(friendsAdapter);
      context=this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), friendsAdapter.getFriend(position) + " is a friend", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private List<Friend> setFriendsandMobile() {
        //read from the String.xml
      String[] friendname=  getResources().getStringArray(R.array.friends);
        String[] friendmobile=  getResources().getStringArray(R.array.molbile);
        List<Friend> lstfriend =new ArrayList<Friend>() ;
        for(int i=0;i<friendname.length;i++)
        {
            lstfriend.add(new Friend(friendname[i],Integer.parseInt(friendmobile[i])));
        }

        return  lstfriend;
    }
    private List<Friend> setFriends() {
        String[] names = getResources().getStringArray(R.array.friends);
        int[] iconID = {
                R.drawable.ic_mood_white_24dp,
                R.drawable.ic_mood_bad_white_24dp,
                R.drawable.ic_sentiment_neutral_white_24dp,
                R.drawable.ic_sentiment_dissatisfied_white_24dp,
                R.drawable.ic_sentiment_satisfied_white_24dp,
                R.drawable.ic_sentiment_very_dissatisfied_white_24dp,
                R.drawable.ic_sentiment_very_satisfied_white_24dp,
        };

        List<Friend> lstfriends = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            lstfriends.add(new Friend(names[i], iconID[i]));
        }

        return lstfriends;
    }

    private AlertDialog locationAlertDialog;
    private void showLocationAlert() {
        if (null == locationAlertDialog)
            locationAlertDialog = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setMessage("This application would like to access your location")
                    .setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        locationAlertDialog.show();

    }
    private void showLocationAlert(String message) {
        if (null == locationAlertDialog)
            locationAlertDialog = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setMessage(message)
                    .setPositiveButton("", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setNegativeButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        locationAlertDialog.show();

    }
    }


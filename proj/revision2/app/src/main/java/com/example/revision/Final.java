package com.example.revision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Final extends AppCompatActivity
{
    TextView data1,data2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        data1=(TextView)findViewById(R.id.lbl1);
        data2=(TextView)findViewById(R.id.lbl2);


        Intent intent = getIntent();

        String Sdata1=intent.getStringExtra("data1");
        String Sdata2=intent.getStringExtra("data2");

        data1.setText(Sdata1);
        data2.setText(Sdata2);



    }
}

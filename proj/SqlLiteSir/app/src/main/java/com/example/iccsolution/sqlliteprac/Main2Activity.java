package com.example.iccsolution.sqlliteprac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void CreateRecord(View V)
    {
        Intent intent = new Intent(this,Main3Activity.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
               String returnString = data.getStringExtra("keyName");

                // Set text view with string
                TextView textView = (TextView) findViewById(R.id.textViewRecordCount1);
                textView.setText(returnString);
            }
        }
    }
}

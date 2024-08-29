package com.example.iccsolution.sqlliteprac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        int recordCount = new TableControllerStudent(this).count();
        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("keyName", "heeelo");
        setResult(RESULT_OK, intent);
        finish();
    }
}

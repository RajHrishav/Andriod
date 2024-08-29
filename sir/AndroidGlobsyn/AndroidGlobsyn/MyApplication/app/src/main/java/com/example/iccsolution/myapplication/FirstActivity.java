package com.example.iccsolution.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    //createing a class referenec
    EditText txtuname=null;
    EditText txtpass=null;
    Button btn=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //getting the textbox from the view
        //typecasting to its orginal type
        txtuname=(EditText)findViewById(R.id.txtusername);
        txtpass=(EditText)findViewById(R.id.txtpass);
        btn=(Button)findViewById(R.id.btnlogin);
        //add the listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show message Box
                Toast.makeText(getApplicationContext(),"user Name"+txtuname.getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"user Password"+txtpass.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        //messagebox

    }
}
